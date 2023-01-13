package com.zasa.fuellyvendor.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.zasa.fuellyvendor.AfterSignup1;
import com.zasa.fuellyvendor.Alerts;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.OTPVerification;
import com.zasa.fuellyvendor.SignUp.SignUpActivity;
import com.zasa.fuellyvendor.models.Member_Detail_Model;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityLoginBinding;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static String PREFS_NAME = "MyPrefsFile";

    ActivityLoginBinding binding;

    private Dialog AnimatedDialog;
    SharedPrefManager sharedPrefManager;
    SharedPreferences sharedPreference;
    Context context;
    String st_phone, st_pass;
    ImageView ib_fingerlogin;
    TextView msgtex;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_PUMP_CODE = "pump_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = LoginActivity.this;
        sharedPrefManager = new SharedPrefManager(context);// call custom sharedPrefManager Class constructure

//        biometric();
        sharedPreference = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
//        boolean Is_checked = sharedPreferences.getBoolean("value", true);
//        if (Is_checked) {
//            binding.btnFingerprintLock.setVisibility(View.VISIBLE);
//            binding.ors.setVisibility(View.VISIBLE);
//
//        } else {
//            binding.btnFingerprintLock.setVisibility(View.GONE);
//            binding.ors.setVisibility(View.GONE);
//        }

        AnimatedDialog = Alerts.showAnimatedLoadingIndicator(context);

        SharedPreferences sp_RememberMe = getSharedPreferences("RememberMe", MODE_PRIVATE);

        String phone = sp_RememberMe.getString("uPhone", "");
        String pass = sp_RememberMe.getString("uPass", "");
        if (!phone.isEmpty() && !pass.isEmpty()) {
            binding.etLoginUsername.setText(phone);
            binding.etLoginPass.setText(pass);
        }
    }

    public void forgetPassword(View view) {
    }

    public void SignUpBtn(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void LoginBtn(View view) {

        if (isValid()) {
            signIn();
        }
    }

    private void signIn() {

        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("hasLoggedIn", true);
        editor.commit();

        Call<Member_Detail_Model> call = ApiClient.getApiService().getMember_Detail(st_phone, st_pass);
        call.enqueue(new Callback<Member_Detail_Model>() {
            @Override
            public void onResponse(Call<Member_Detail_Model> call, Response<Member_Detail_Model> response) {
                if (response.isSuccessful()) {
                    AnimatedDialog.show();
                    assert response.body() != null;
                    if (response.body().getStatus().equals("1")) {
                        Member_Detail_Model memberDetailModel = response.body();

                        sharedPreference = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreference.edit();
                        editor.putString(KEY_PUMP_CODE, memberDetailModel.getPump_Details().getPump_code());
                        editor.apply();

                        Toast.makeText(LoginActivity.this, "Login Successfuly", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Member_Detail_Model> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void biometric() {
//
//        // BIOMETRIC FINGERPRINT
//        BiometricManager biometricManager = BiometricManager.from(this);
//        switch (biometricManager.canAuthenticate()) {
//
//            // this means we can use biometric sensor
//            case BiometricManager.BIOMETRIC_SUCCESS:
//                binding.txtFingerprint.setText("You can use the fingerprint sensor to login");
//                binding.txtFingerprint.setTextColor(Color.parseColor("#fafafa"));
//                break;
//
//            // this means that the device doesn't have fingerprint sensor
//            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
//                binding.txtFingerprint.setText("This device doesnot have a fingerprint sensor");
//                binding.btnFingerprintLock.setVisibility(View.GONE);
//                break;
//
//            // this means that biometric sensor is not available
//            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
//                binding.txtFingerprint.setText("The biometric sensor is currently unavailable");
//                binding.btnFingerprintLock.setVisibility(View.GONE);
//                break;
//
//            // this means that the device doesn't contain your fingerprint
//            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
//                binding.txtFingerprint.setText("Your device doesn't have fingerprint saved,please check your security settings");
//                binding.btnFingerprintLock.setVisibility(View.GONE);
//                break;
//        }
//
//        Executor executor = ContextCompat.getMainExecutor(this);
//        // this will give us result of AUTHENTICATION
//        final BiometricPrompt biometricPrompt = new BiometricPrompt(LoginActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
//            @Override
//            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
//                super.onAuthenticationError(errorCode, errString);
//            }
//
//            // THIS METHOD IS CALLED WHEN AUTHENTICATION IS SUCCESS
//            @Override
//            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
//                binding.txtFingerprint.setText("Login Successful");
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed();
//            }
//        });
//
//        // creating a variable for our promptInfo
//        // BIOMETRIC DIALOG
//        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
//                .setTitle(getResources().getString(R.string.app_name))
//                .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel").build();
//        binding.btnFingerprintLock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                biometricPrompt.authenticate(promptInfo);
//
//            }
//        });
//    }

    private boolean isValid() {

        st_phone = binding.etLoginUsername.getText().toString().trim();
        st_pass = binding.etLoginPass.getText().toString().trim();

        boolean is_valid = true;

        if (st_phone.length() < 11) {
            binding.etLoginUsername.requestFocus();
            binding.etLoginUsername.setError("Enter correct phone number!");
            is_valid = false;
        }

        if (st_pass.length() < 3) {
            binding.etLoginPass.requestFocus();
            binding.etLoginPass.setError("Password must contains 4-digits!");
            is_valid = false;
        }

        if (binding.cbLoginScr.isChecked()) {
            sharedPrefManager.rememberMe(st_phone, st_pass);//put values in sharedPreference
        }

        return is_valid;
    }

    @Override
    public void onClick(View v) {
    }
}