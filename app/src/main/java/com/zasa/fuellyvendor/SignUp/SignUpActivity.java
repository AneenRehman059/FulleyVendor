package com.zasa.fuellyvendor.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zasa.fuellyvendor.AfterSignup1;
import com.zasa.fuellyvendor.Fragments.PumpDetailFragment;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.OTPVerification;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = SignUpActivity.this;
        sharedPrefManager = new SharedPrefManager(context);// call custom sharedPrefManager Class constructure

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");



    }

    public void SignUpBtn(View view) {


        String st_Username = binding.signupUsername.getText().toString().trim();
        String st_Phone = binding.signupPhone.getText().toString().trim();
        String st_pass = binding.signupPin.getText().toString().trim();
        String st_CnfPass = binding.signupCnfPin.getText().toString().trim();

        if (TextUtils.isEmpty(st_Username)) {
            binding.signupUsername.requestFocus();
            binding.signupUsername.setError("Enter correct username!");
            return;
        }
        if (st_Phone.length() != 11) {
            binding.signupPhone.requestFocus();
            binding.signupPhone.setError("Enter correct mobile number");
            return;
        }



        if (st_pass.length() < 4 || st_pass.isEmpty()) {
            binding.signupPin.requestFocus();
            binding.signupPin.setError("Password must contains 4-digits!");
            return;
        }

        if (!st_CnfPass.equals(st_pass) || st_CnfPass.isEmpty()) {
            binding.signupCnfPin.requestFocus();
            binding.signupCnfPin.setError("Password did not match!");
            return;
        }

        String getMobileText = binding.signupPhone.getText().toString();
//                String getEmailText = binding.signupPhone.getText().toString();
        Intent intent = new Intent(SignUpActivity.this,AfterSignup1.class);
        intent.putExtra("mobile",getMobileText);

        startActivity(intent);
//        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void LoginBtn(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void closeBtn(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}