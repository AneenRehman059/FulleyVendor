package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.zasa.fuellyvendor.SignUp.SignUpActivity;

public class SignUpOtp extends AppCompatActivity {
    AppCompatButton after_sign_up;
    public static String PREFS_NAME="MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_otp);

        after_sign_up = findViewById(R.id.verifyOtpBtn_signup);

        after_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(SignUpOtp.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean("hasSignedUp",true);
                editor.commit();
                startActivity(new Intent(SignUpOtp.this, SignUpActivity.class));
                finish();

            }
        });
    }
}
