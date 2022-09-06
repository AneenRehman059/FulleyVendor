package com.zasa.fuellyvendor.Login;

import static com.zasa.fuellyvendor.Constants.FINGER_PRINT_PREFS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.zasa.fuellyvendor.AfterSignup1;
import com.zasa.fuellyvendor.Fragments.PumpDetailFragment;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.HomeFragment;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.SignUp.SignUpActivity;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityLoginBinding;

import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

public static String PREFS_NAME="MyPrefsFile";

    ActivityLoginBinding binding;

    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    Context context;
    ImageView ib_fingerlogin;
    TextView msgtex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = LoginActivity.this;
        sharedPrefManager = new SharedPrefManager(context);// call custom sharedPrefManager Class constructure

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");

        SharedPreferences sp_RememberMe = getSharedPreferences("RememberMe", MODE_PRIVATE);
        String phone = sp_RememberMe.getString("uPhone", "");
        String pass = sp_RememberMe.getString("uPass", "");
        if (!phone.isEmpty() && !pass.isEmpty()) {
            binding.etLoginUsername.setText(phone);
            binding.etLoginPass.setText(pass);

        }

//        binding.btnFingerprintLock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Biometric lock is under processing!", Toast.LENGTH_SHORT).show();
//
//            }
//        });



    }

    public void forgetPassword(View view) {
    }

    public void SignUpBtn(View view) {
        startActivity(new Intent(this, AfterSignup1.class));

    }

    public void LoginBtn(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("hasLoggedIn",true);
        editor.commit();
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        finish();

        String st_Username = binding.etLoginUsername.getText().toString().trim();
        String st_pass = binding.etLoginPass.getText().toString().trim();


//        if (st_Username.length() != 11) {
//            et_Phone.requestFocus();
//            et_Phone.setError("Enter correct mobile number");
//            return;
//        }

        if (TextUtils.isEmpty(st_Username)) {
            binding.etLoginUsername.requestFocus();
            binding.etLoginUsername.setError("Enter correct username!");
            return;
        }

        if (st_pass.length() < 4) {
            binding.etLoginPass.requestFocus();
            binding.etLoginPass.setError("Password must contains 4-digits!");
            return;
        }

        progressDialog.show();

        if (binding.cbLoginScr.isChecked()) {
            sharedPrefManager.rememberMe(st_Username, st_pass);//put values in sharedPreference
        }

        progressDialog.dismiss();
        //Toast.makeText(LoginActivity.this, "" + loginApi.getMessage(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        finish();


    }

    @Override
    public void onClick(View v) {

    }
}