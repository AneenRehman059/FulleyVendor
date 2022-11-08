package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.GetQrData_Model;
import com.zasa.fuellyvendor.models.getFuelUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Check_Fuel_LimitActivity extends AppCompatActivity {
    Button disburst;
    ImageView success;
    EditText enterFuel;
    double e_fuel;
    TextView loca, fleetCode, fuel_ltr;
    LocationManager locationManager;
    private static final int REQUEST_LOCATION = 1;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_fuel_limit);

        disburst = findViewById(R.id.btn_disburst);
        fleetCode = findViewById(R.id.fleetCode);
        fuel_ltr = findViewById(R.id.fuelLtr);
        success = findViewById(R.id.check);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fly_in_from_left);
        success.startAnimation(animation);

        String s = getIntent().getStringExtra("code");
//        fleetCode.setText(s.split("U")[1]);

//        Call<GetQrData_Model> modelCall = ApiClient.getApiService().getQRData(1,s);
//        modelCall.enqueue(new Callback<GetQrData_Model>() {
//            @Override
//            public void onResponse(Call<GetQrData_Model> call, Response<GetQrData_Model> response) {
//                GetQrData_Model qrDetail = response.body();
//
//                if (response.isSuccessful()){
//                    fuel_ltr.setText(qrDetail.getQR_Details().getMember_FName());
//                }
//                else {
//                    Toast.makeText(Check_Fuel_LimitActivity.this, "No Fuel Up", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetQrData_Model> call, Throwable t) {
//                Toast.makeText(Check_Fuel_LimitActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}