package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.models.getFuelUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Check_Fuel_LimitActivity extends AppCompatActivity {
    Button disburst;
    EditText enterFuel;
    double e_fuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_fuel_limit);

        disburst = findViewById(R.id.btn_disburst);
        enterFuel = findViewById(R.id.enter_fuel);

        String s = getIntent().getStringExtra("code");


        disburst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enter_fuel = enterFuel.getText().toString();
                e_fuel = Double.parseDouble(enter_fuel);
                Call<getFuelUp> call = ApiClient.getApiService().getQrFuelup(s, "", e_fuel, "", "", "Test Location for entry or APIs testing");
                call.enqueue(new Callback<getFuelUp>() {
                    @Override
                    public void onResponse(Call<getFuelUp> call, Response<getFuelUp> response) {
                        if (response.isSuccessful()) {
                            Intent intent = new Intent(Check_Fuel_LimitActivity.this, HomeActivity.class);
                            Toast.makeText(Check_Fuel_LimitActivity.this, "Fuell refill successfuly", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<getFuelUp> call, Throwable t) {
                        Toast.makeText(Check_Fuel_LimitActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}