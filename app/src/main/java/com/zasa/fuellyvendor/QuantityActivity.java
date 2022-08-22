package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityQuantityBinding;

public class QuantityActivity extends AppCompatActivity {


    ActivityQuantityBinding binding;
    private Context context;
    private Dialog AnimatedDialog;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    String selectedLiters,selectedFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        binding = ActivityQuantityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = QuantityActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);


        selectedFuel =getIntent().getStringExtra("selectedFuel");

    }

    public void btnBack(View view) {
        finish();
    }

    public void btnGenerateQr(View view) {
        Intent intent = new Intent(context,QRScreenActivity.class);

        if(!TextUtils.isEmpty(binding.etLiters.getText().toString())){
            selectedLiters=binding.etLiters.getText().toString();
        }
        intent.putExtra("selectedLiters",selectedLiters);
        intent.putExtra("selectedFuel",selectedFuel);
        startActivity(intent);


    }

    public void btn35Liter(View view) {
        selectedLiters = binding.liter35.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }


    public void btn30Liter(View view) {
        selectedLiters = binding.liter30.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btn5Liter(View view) {
        selectedLiters = binding.liter5.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btn10Liter(View view) {
        selectedLiters = binding.liter10.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btn15Liter(View view) {
        selectedLiters = binding.liter15.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btn20Liter(View view) {
        selectedLiters = binding.liter20.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btn25Liter(View view) {
        selectedLiters = binding.liter25.getText().toString();
        Toast.makeText(context, selectedLiters + " is selected!", Toast.LENGTH_SHORT).show();
    }
}