package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class Create_Tpin extends AppCompatActivity {
    Pinview pinview;
    Button verfiy_tpin;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String OTP_VALUE = "otp_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tpin);

        pinview = findViewById(R.id.myPinView);
        verfiy_tpin = findViewById(R.id.verify);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        verfiy_tpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pin = pinview.getValue();
                Toast.makeText(Create_Tpin.this, "OTP"+pin, Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(OTP_VALUE,pin);
                editor.apply();
                Intent intent = new Intent(Create_Tpin.this,HomeActivity.class);
                startActivity(intent);

//                if (!pin.equals(PrefsManager.getPin())) {
//                    Toast.makeText(Create_Tpin.this, "Wrong Pin", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Intent intent = new Intent(Create_Tpin.this , HomeActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
            }
        });
    }
}