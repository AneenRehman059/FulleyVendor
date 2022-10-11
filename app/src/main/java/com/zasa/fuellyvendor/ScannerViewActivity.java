package com.zasa.fuellyvendor;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.getFuelUp;
import com.zasa.fuellyvendor.models.getQrData_Model;


import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScannerViewActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    Context context;
    ProgressDialog progressDialog;

    ZXingScannerView zXingScannerView;
    ImageView flashOn, flashOff;
    TextView TextLay;

    String Material_Code, Client_Code, Company_Code, Material_Name;
    int Material_Type, Material_IsActive;
    float One_Material_LB_Points, Material_LB_Points, Material_LB_Points_Total;
    int Material_Qty = 1;
    boolean mAutoFocus;

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
        /// TextLay.setSelected(true);  // Set focus to the textview (moving text)
        // TextLay.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        requestForCameraPermission();

    }

    private void getQrData() {
        String s = getIntent().getStringExtra("code");

        Call<getQrData_Model.QR_Details> call = ApiClient.getApiService().getQRData(1,s);
        call.enqueue(new Callback<getQrData_Model.QR_Details>() {
            @Override
            public void onResponse(Call<getQrData_Model.QR_Details> call, Response<getQrData_Model.QR_Details> response) {
                getQrData_Model.QR_Details getQrDataModel = response.body();
                assert getQrDataModel != null;
                if (getQrDataModel.getQR_Type() == 2){
                    if (getQrDataModel.getFix_Pump_Code() != null){
                        if (getQrDataModel.getFix_Pump_Code().equals(getQrDataModel.getPump_Code())){
                            Intent intent = new Intent(ScannerViewActivity.this,Check_Fuel_LimitActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(ScannerViewActivity.this, "Not allowed to fuel up thid pump", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Intent intent = new Intent(ScannerViewActivity.this,Check_Fuel_LimitActivity.class);
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent = new Intent(ScannerViewActivity.this,Check_Fuel_LimitActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<getQrData_Model.QR_Details> call, Throwable t) {
                Toast.makeText(ScannerViewActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void handleResult(Result rawResult) {

        //scanned item code
        String Code = rawResult.getText();

        Toast.makeText(context, ""+Code, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, Check_Fuel_LimitActivity.class);
        intent.putExtra("code", Code);
        startActivity(intent);
        getQrData();
       finish();

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