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

import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.Splash.SplashActivity;

import java.util.concurrent.Executor;

public class OTPVerification extends AppCompatActivity implements View.OnClickListener {
    private EditText OTPEt1, OTPEt2, OTPEt3, OTPEt4;
    private TextView resendBtn;
    AppCompatButton verifyBtn;
    ImageView ib_fingerlogin;
    TextView msgtex,sugn_up;
    LinearLayout Or;
    public static String PREFS_NAME="save";

    // true after every 60 sec
    private boolean resnedEnabled = false;

    // resend time in seconds
    private int resendTime = 60;

    private int selectedETPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);


        // getting email and mobile from Register activity through intent
//        final String getEmail = getIntent().getStringExtra("email");
        final String getMobile = getIntent().getStringExtra("mobile");

        final TextView otpMobile = findViewById(R.id.otpMobile);
        // setting email and mobile on textview
        otpMobile.setText(getMobile);

        initView();
        biometric();


        OTPEt1.addTextChangedListener(textWatcher);
        OTPEt2.addTextChangedListener(textWatcher);
        OTPEt3.addTextChangedListener(textWatcher);
        OTPEt4.addTextChangedListener(textWatcher);


        SharedPreferences sharedPreferences = getSharedPreferences(OTPVerification.PREFS_NAME,0);
        boolean Is_checked = sharedPreferences.getBoolean("value",true);
        if (Is_checked){
            ib_fingerlogin.setVisibility(View.VISIBLE);
            Or.setVisibility(View.VISIBLE);

        }
        else {
            ib_fingerlogin.setVisibility(View.GONE);
            Or.setVisibility(View.GONE);
        }

        showKeyboard(OTPEt1);

        // start resend count down timer
        startCountDownTimer();

        verifyBtn.setOnClickListener(this);
        resendBtn.setOnClickListener(this);

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
                Intent intent = new Intent(OTPVerification.this,HomeActivity.class);
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
    }

    private void initView() {
        ib_fingerlogin = findViewById(R.id.btnFingerprintLock);
        msgtex = findViewById(R.id.txt_fingerprint);

        OTPEt1 = findViewById(R.id.otpET1);
        OTPEt2 = findViewById(R.id.otpET2);
        OTPEt3 = findViewById(R.id.otpET3);
        OTPEt4 = findViewById(R.id.otpET4);

        resendBtn = findViewById(R.id.resendOtp);
        verifyBtn = findViewById(R.id.verifyOtpBtn);
        Or = (LinearLayout) findViewById(R.id.or);

        final TextView otpEmail = findViewById(R.id.otpEmail);

    }

    private void showKeyboard(EditText otpEt) {
        otpEt.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpEt, InputMethodManager.SHOW_IMPLICIT);
    }

    private void startCountDownTimer() {
        resnedEnabled = false;
        resendBtn.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                resendBtn.setText("Resend Code ( " + (millisUntilFinished / 60) + ")");
            }

            @Override
            public void onFinish() {
                resnedEnabled = true;
                resendBtn.setText("Resend Code");
                resendBtn.setTextColor(getResources().getColor(R.color.primary));
            }
        }.start();
    }


    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() > 0) {
                if (selectedETPosition == 0) {
                    selectedETPosition = 1;
                    showKeyboard(OTPEt2);
                } else if (selectedETPosition == 1) {
                    selectedETPosition = 2;
                    showKeyboard(OTPEt3);
                } else if (selectedETPosition == 2) {
                    selectedETPosition = 3;
                    showKeyboard(OTPEt4);
                }
            }
        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (selectedETPosition == 3) {
                selectedETPosition = 2;
                showKeyboard(OTPEt3);
            } else if (selectedETPosition == 2) {
                selectedETPosition = 1;

                showKeyboard(OTPEt2);
            } else if (selectedETPosition == 1) {
                selectedETPosition = 0;
                showKeyboard(OTPEt1);
            }

            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }

    @Override
    public void onClick(View v) {
       if (v.getId() == R.id.resendOtp){
           if (resnedEnabled) {
               // handle your resend code here

               // start new resend count down timer
               startCountDownTimer();
           }
       }
       else if (v.getId() == R.id.verifyOtpBtn){
           final String generateOtp = OTPEt1.getText().toString()
                   + OTPEt2.getText().toString()
                   + OTPEt3.getText().toString()
                   + OTPEt4.getText().toString();

           if (generateOtp.length() == 4) {
               // handle your otp verification here
           }
           Intent intent = new Intent(OTPVerification.this,HomeActivity.class);
           startActivity(intent);
       }
    }
}