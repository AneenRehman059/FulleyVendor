package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityFuelQrCodeBinding;

public class FuelQrCodeActivity extends AppCompatActivity {

    ActivityFuelQrCodeBinding binding;
    private Context context;
    private Dialog AnimatedDialog;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;

    String fuelType, Liters, intentCode;
    double rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_qr_code);

        binding = ActivityFuelQrCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        context = FuelQrCodeActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);


        intentCode = getIntent().getStringExtra("code");
        String[] OData = intentCode.split(",");
        fuelType = OData[0];
        Liters = OData[1];
        rate = 235.89;

        String digits = Liters.replaceAll("[^0-9]", "");


        binding.tvFuelType.setText(fuelType);
        binding.tvFuelLiters.setText(Liters);
        binding.tvRate.setText(rate+"");

        double total = rate*Long.parseLong(digits);
        binding.tvAmount.setText("Rs. "+Math.round(total));


    }


    public void btnBack(View view) {
        finish();
    }

    public void btnDone(View view) {
        //startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}