package com.zasa.fuellyvendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.mattprecious.swirl.SwirlView;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.Splash.SplashActivity;
import com.zasa.fuellyvendor.databinding.ActivityOtpverificationBinding;

import java.util.concurrent.Executor;

public class OTPVerification extends AppCompatActivity  {
    private EditText OTPEt1, OTPEt2, OTPEt3, OTPEt4;
    private TextView resendBtn;
    AppCompatButton verifyBtn;
    ImageView ib_fingerlogin , login_tp;
    TextView msgtex, sugn_up;
    LinearLayout Or;
    Pinview pinview;
    public static String PREFS_NAME = "save";
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String OTP_VALUE = "otp_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

//        String pin = binding.myPinViewID.getValue();
        initView();
        biometric();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(OTP_VALUE,null);
        Toast.makeText(this, "OTP"+name, Toast.LENGTH_SHORT).show();

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                String pin = pinview.getValue();
                if (!pin.equals(name)){
                    Toast.makeText(OTPVerification.this, "Wrong Pin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(OTPVerification.this , HomeActivity.class);
                    startActivity(i);
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(OTPVerification.PREFS_NAME, 0);
        boolean Is_checked = sharedPreferences.getBoolean("value", true);
        if (Is_checked) {
            ib_fingerlogin.setVisibility(View.VISIBLE);


        } else {
            ib_fingerlogin.setVisibility(View.GONE);
        }

    }


    private void biometric() {

        // BIOMETRIC FINGERPRINT
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {

            // this means we can use biometric sensor
            case BiometricManager.BIOMETRIC_SUCCESS:
                msgtex.setText("You can use the fingerprint sensor to login");
                msgtex.setTextColor(Color.parseColor("#fafafa"));
                break;

            // this means that the device doesn't have fingerprint sensor
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                msgtex.setText("This device doesnot have a fingerprint sensor");
                ib_fingerlogin.setVisibility(View.GONE);
                break;

            // this means that biometric sensor is not available
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                msgtex.setText("The biometric sensor is currently unavailable");
                ib_fingerlogin.setVisibility(View.GONE);
                break;

            // this means that the device doesn't contain your fingerprint
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                msgtex.setText("Your device doesn't have fingerprint saved,please check your security settings");
                ib_fingerlogin.setVisibility(View.GONE);
                break;
        }


        Executor executor = ContextCompat.getMainExecutor(this);
        // this will give us result of AUTHENTICATION
        final BiometricPrompt biometricPrompt = new BiometricPrompt(OTPVerification.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            // THIS METHOD IS CALLED WHEN AUTHENTICATION IS SUCCESS
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                msgtex.setText("Login Successful");
                Intent intent = new Intent(OTPVerification.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        // creating a variable for our promptInfo
        // BIOMETRIC DIALOG
        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(getResources().getString(R.string.app_name))
                .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel").build();
        ib_fingerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);

            }
        });

//        login_tp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(OTPVerification.this , LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void initView() {
//        login_tp = findViewById(R.id.login_tp);
        msgtex = findViewById(R.id.txt_fingerprint);
        pinview = findViewById(R.id.myPinViewID);
        ib_fingerlogin = findViewById(R.id.btnFingerprintLock);
//        verifyBtn = findViewById(R.id.verifyOtpBtn);

    }

}