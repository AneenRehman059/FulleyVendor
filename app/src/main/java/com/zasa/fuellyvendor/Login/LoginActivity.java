package com.zasa.fuellyvendor.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.zasa.fuellyvendor.AfterSignup1;
import com.zasa.fuellyvendor.Alerts;
import com.zasa.fuellyvendor.HomeActivity;
import com.zasa.fuellyvendor.models.Member_Detail_Model;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;
import com.zasa.fuellyvendor.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

public static String PREFS_NAME="MyPrefsFile";

    ActivityLoginBinding binding;

    private Dialog AnimatedDialog;
    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    Context context;
    String st_phone,st_pass;
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

        AnimatedDialog = Alerts.showAnimatedLoadingIndicator(context);

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

        if (isValid()){
            signIn();
        }

    }

    private void signIn() {


        AnimatedDialog.show();
        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("hasLoggedIn",true);
        editor.commit();
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        finish();
        AnimatedDialog.dismiss();

        Call<Member_Detail_Model> call = ApiClient.getApiService().getMember_Detail(st_phone,st_pass);
        call.enqueue(new Callback<Member_Detail_Model>() {
            @Override
            public void onResponse(Call<Member_Detail_Model> call, Response<Member_Detail_Model> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus() == 1){
                        Toast.makeText(LoginActivity.this, "Login Successfuly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<Member_Detail_Model> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValid(){

        st_phone = binding.etLoginUsername.getText().toString().trim();
        st_pass = binding.etLoginPass.getText().toString().trim();

        boolean is_valid = true;

        if (st_phone.length()<11) {
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