package com.zasa.fuellyvendor;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.GetQrData_Model;
import com.zasa.fuellyvendor.models.getFuelUp;


import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScannerViewActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    Context context;
    ProgressDialog progressDialog;
    String code;
    String expireQr,fuelUpLocation;
    double actualFuel;

    ZXingScannerView zXingScannerView;
    ImageView flashOn, flashOff;
    TextView TextLay;
    String latitude;
    String longitude;
    LocationManager locationManager;
    private static final int REQUEST_LOCATION = 1;
    String loca;
    SharedPreferences sharedPreference;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_PUMP_CODE = "pump_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_view);

        if (savedInstanceState != null) {
            // mAutoFocus = savedInstanceState.getBoolean(AUTO_FOCUS_STATE, true);

        }

        context = ScannerViewActivity.this;

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");

        flashOn = findViewById(R.id.flashOn);
        flashOff = findViewById(R.id.flashOff);
        zXingScannerView = findViewById(R.id.zxing);
        TextLay = findViewById(R.id.Text);

        sharedPreference = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        /// TextLay.setSelected(true);  // Set focus to the textview (moving text)
        // TextLay.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        requestForCameraPermission();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // check gps enable or not
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            // write function to enable gps
            OnGps();
        } else {
            // GPS already On then
            getLocation();
        }
    }

    private void getQrData() {
//        s = getIntent().getStringExtra("code")

        String fullQr = code;
        String s = fullQr.substring(0,1);

//        fullQr.substring(0,1) != "U"

        if (!code.startsWith("U")){

            Call<GetQrData_Model> callQr = ApiClient.getApiService().getQRData(1,fullQr);
            callQr.enqueue(new Callback<GetQrData_Model>() {
                @Override
                public void onResponse(Call<GetQrData_Model> call, Response<GetQrData_Model> response) {
                    GetQrData_Model qrDetails = response.body();
                    if (response.isSuccessful()){

                        Toast.makeText(context, qrDetails.getQR_Details().getMember_FName(), Toast.LENGTH_SHORT).show();
                        String loginPumpCode = sharedPreference.getString(KEY_PUMP_CODE, null);
                    }
                    else {
                        Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GetQrData_Model> call, Throwable t) {
                    Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {

            String splitQr = code.split("U")[1];

            Call<GetQrData_Model> call = ApiClient.getApiService().getQRData(1, splitQr);
            call.enqueue(new Callback<GetQrData_Model>() {
                @Override
                public void onResponse(Call<GetQrData_Model> call, Response<GetQrData_Model> response) {
                    GetQrData_Model qrDetails = response.body();
                    Toast.makeText(ScannerViewActivity.this, splitQr, Toast.LENGTH_SHORT).show();
                    expireQr = qrDetails.getQR_Details().getQR_Expired_On();
                    actualFuel = qrDetails.getQR_Details().getActual_Fuel();
                    fuelUpLocation = qrDetails.getQR_Details().getFuel_Up_Location();
                    if (response.isSuccessful()) {
                        String loginPumpCode = sharedPreference.getString(KEY_PUMP_CODE, null);
                        if (qrDetails.getQR_Details().getFix_Pump_Code() == loginPumpCode)
                        {
                           Call<getFuelUp> callFuelUp = ApiClient.getApiService().getQrFuelup(splitQr,loginPumpCode,expireQr,actualFuel,latitude,longitude,fuelUpLocation);
                       callFuelUp.enqueue(new Callback<getFuelUp>() {
                           @Override
                           public void onResponse(Call<getFuelUp> call, Response<getFuelUp> response) {
                               if (response.isSuccessful()){

                                   Intent intent = new Intent(ScannerViewActivity.this,Check_Fuel_LimitActivity.class);
                                   startActivity(intent);
                               }
                               else {
                                   getFuelUp fuelUp = response.body();
                                   Toast.makeText(ScannerViewActivity.this,fuelUp.getMessage() , Toast.LENGTH_SHORT).show();
                               }
                           }

                           @Override
                           public void onFailure(Call<getFuelUp> call, Throwable t) {
                               Toast.makeText(ScannerViewActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                           }
                       });
                        }
                        else {
                            Toast.makeText(context, "You are not allowed to Fuel Up from this .", Toast.LENGTH_SHORT).show();
                        }
                    } else
                    {
                        Toast.makeText(ScannerViewActivity.this, "Somthing Wrong Try Again", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GetQrData_Model> call, Throwable t) {
                    Toast.makeText(ScannerViewActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

//        Call<GetQrData_Model> call = ApiClient.getApiService().getQRData(1, s);
//        call.enqueue(new Callback<GetQrData_Model>() {
//            @Override
//            public void onResponse(Call<GetQrData_Model> call, Response<GetQrData_Model> response) {
//                GetQrData_Model qrDetails = response.body();
//                String code = qrDetails.getMessage();
//                Toast.makeText(ScannerViewActivity.this, "Fleet Code :" + code, Toast.LENGTH_SHORT).show();
//
//                String getQrId = qrDetails.getQR_Details().getQR_Id();
//                double actualFuel = qrDetails.getQR_Details().getActual_Fuel();
//                String fuelUpLocation = qrDetails.getQR_Details().getFuel_Up_Location();
//
//                if (qrDetails.getQR_Details().getQR_Type() == 2) {
//                    if (qrDetails.getQR_Details().getFix_Pump_Code() != null) {
//                        if (qrDetails.getQR_Details().getFix_Pump_Code().equals(qrDetails.getQR_Details().getPump_Code())) {
//
//                        } else {
//                            Toast.makeText(ScannerViewActivity.this, "Not allowed to fuel up thid pump", Toast.LENGTH_SHORT).show();
//
//                        }
//                    } else {
//                        Intent intent = new Intent(ScannerViewActivity.this, Check_Fuel_LimitActivity.class);
//                        startActivity(intent);
//                    }
//                } else {
//                    Intent intent1 = new Intent(ScannerViewActivity.this, Check_Fuel_LimitActivity.class);
//                    startActivity(intent1);
////                    Toast.makeText(ScannerViewActivity.this,("Your Location "+"\n"+"Latitude: "+latitude+"Longitude: "+longitude), Toast.LENGTH_SHORT).show();
//                    String fcode = qrDetails.getQR_Details().getFleet_Code();
//                    Toast.makeText(ScannerViewActivity.this, "Fleet" + fcode, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<GetQrData_Model> call, Throwable t) {
//                Toast.makeText(ScannerViewActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public void handleResult(Result rawResult) {

        //scanned item code
        code = rawResult.getText();
        Toast.makeText(context, "" + code, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, Check_Fuel_LimitActivity.class);
        intent.putExtra("code", code);
        startActivity(intent);
        getQrData();


    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.setAspectTolerance(0.2f);

        //zXingScannerView.setAutoFocus(true);
        //zXingScannerView.setSoundEffectsEnabled(true);
        requestForCameraPermission();


    }

    private void requestForCameraPermission() {
        Dexter.withContext(getApplicationContext())  //Dexter is used for runtime permission
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        zXingScannerView.setResultHandler(ScannerViewActivity.this);
                        zXingScannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        requestForCameraPermission();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();  //ask continuously for permission utill he grant permission
                    }
                }).check();
    }

    private void getLocation() {
        // Check permission again
        if (ActivityCompat.checkSelfPermission(ScannerViewActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ScannerViewActivity.this
                , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION
            );
        } else {
            Location LocationGps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (LocationGps != null) {
                double lat = LocationGps.getLatitude();
                double longi = LocationGps.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

//                loca.setText("Your Location "+"\n"+"Latitude: "+latitude+"Longitude: "+longitude);
            } else if (LocationNetwork != null) {
                double lat = LocationNetwork.getLatitude();
                double longi = LocationNetwork.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

//                loca.setText("Your Location "+"\n"+"Latitude: "+latitude+"Longitude: "+longitude);
            } else if (LocationPassive != null) {
                double lat = LocationPassive.getLatitude();
                double longi = LocationPassive.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

//                loca.setText("Your Location "+"\n"+"Latitude: "+latitude+"Longitude: "+longitude);
            } else {
                Toast.makeText(context, "Can't get your Location", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void OnGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable Gps")
                .setCancelable(false)
                .setPositiveButton("YEs", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void flashOn(View view) {

        zXingScannerView.setFlash(true);
        flashOn.setVisibility(View.GONE);
        flashOff.setVisibility(View.VISIBLE);
    }

    public void flashOff(View view) {
        zXingScannerView.setFlash(false);
        flashOn.setVisibility(View.VISIBLE);
        flashOff.setVisibility(View.GONE);
    }


    private void restartScanner() {
        zXingScannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        zXingScannerView.resumeCameraPreview(ScannerViewActivity.this);
                    }
                }, 1000);


//                zXingScannerView.setResultHandler(ScannerViewActivity.this);
//                zXingScannerView.startCamera();
            }
        });
    }


}