package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    private Context context;
    private Dialog AnimatedDialog;
    SharedPrefManager sharedPrefManager;
    ProgressDialog progressDialog;
    String selectedFuel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = ProductActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        sharedPrefManager = new SharedPrefManager(context);
    }

    public void btnBack(View view) {
        finish();
    }

    public void btnSuper(View view) {
        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.superOil.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();

    }

    public void btnHiOct(View view) {

        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.hIOctOil.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btnDiesel(View view) {
        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.diesel.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();

    }

    public void btnCng(View view) {

        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.cng.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();
    }

    public void btnLPG(View view) {
        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.lpg.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();

    }

    public void btnEV(View view) {
        Intent intent = new Intent(context, QuantityActivity.class);
        selectedFuel = binding.ev.getText().toString();
        intent.putExtra("selectedFuel", selectedFuel);
        startActivity(intent);
        Toast.makeText(context, selectedFuel + " is selected!", Toast.LENGTH_SHORT).show();

    }
}