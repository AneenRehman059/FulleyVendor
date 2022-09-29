package com.zasa.fuellyvendor.Splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.zasa.fuellyvendor.Retrofit.ApiClient;
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.OTPVerification;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Request.App_Detail_Request;
import com.zasa.fuellyvendor.SignUpOtp;
import com.zasa.fuellyvendor.Utils.Internet;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    public static String PREFS_NAME="MyPrefsFile";

    AppUpdateManager appUpdateManager;
    public static final int RC_APP_UPDATEE = 104;

    private static final long SPLASH_SCREEN_TIME_OUT = 2000;//3sec
    Context context;
    ProgressBar progressBar;
    SharedPrefManager sharedPrefManager;
    boolean isHandlerRun = true;
    TextView solo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //off dark mode

//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            //When night mode is equal to yes
//            //Set dark theme
//            setTheme(R.style.Theme_Dark);
//        } else {
//            //when night mode is equal to no
//            //Set Light theme
//            setTheme(R.style.Theme_Light);}


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            solo = findViewById(R.id.solo);

        Call<App_Detail_Request> call = ApiClient.getApiService().appDetails("FV");
        call.enqueue(new Callback<App_Detail_Request>() {
            @Override
            public void onResponse(Call<App_Detail_Request> call, Response<App_Detail_Request> response) {
                App_Detail_Request app_detail_request = response.body();
                if (response.isSuccessful()){
                    String solod  = app_detail_request.getApp_Details().getAppSolo();
                    solo.setText(solod);
                }
            }

            @Override
            public void onFailure(Call<App_Detail_Request> call, Throwable t) {
                Toast.makeText(context, "Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            // To hide Status bar
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            context = SplashActivity.this;
            progressBar = findViewById(R.id.progressbar);


            ///////app update 1///////
            appUpdateManager = AppUpdateManagerFactory.create(this);
            appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
                @Override
                public void onSuccess(AppUpdateInfo result) {
                    if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                            && result.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                        try {
                            appUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE,
                                    SplashActivity.this, RC_APP_UPDATEE);
                        } catch (IntentSender.SendIntentException e) {
                            Toast.makeText(context, "update error", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    } else {
                        handler();
                        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();

                    }
                }
            });

            handler();


        }

        ///////app update 2////
        private InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() {
            @Override
            public void onStateUpdate(@NonNull InstallState state) {
                if (state.installStatus() == InstallStatus.DOWNLOADED) {
                    showCompletedUpdate();
                }
            }
        };

        private void showCompletedUpdate () {

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "New App is ready!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Install", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appUpdateManager.completeUpdate();
                }
            });
            snackbar.show();
        }

        @Override
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            /////////update app condition
            if (requestCode == RC_APP_UPDATEE && resultCode != RESULT_OK) {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onResume () {
            super.onResume();

            //  appUpdateManager = AppUpdateManagerFactory.create(this);
            appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
                @Override
                public void onSuccess(AppUpdateInfo result) {
                    if (result.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                        try {
                            appUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, SplashActivity.this, RC_APP_UPDATEE);
                        } catch (IntentSender.SendIntentException e) {
                            Toast.makeText(context, "2 error", Toast.LENGTH_SHORT).show();

                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        ////////////////////////////app update 2 end////////////

        private void handler () {
            if (!Internet.isNetConnected(context)) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "You are not connected with internet!", Toast.LENGTH_LONG).show();
                onBackPressed();
            } else {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        SharedPreferences sharedPreferences = getSharedPreferences(SplashActivity.PREFS_NAME,0);
                        boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
                        boolean hasSignedUp = sharedPreferences.getBoolean("hasSignedUp",false);

                        if (hasLoggedIn){
                            Intent intent = new Intent(SplashActivity.this, OTPVerification.class);
                            startActivity(intent);
                            finish();
                        }


                        else {
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        if (hasSignedUp){
                            Intent intent = new Intent(SplashActivity.this, OTPVerification.class);
                            startActivity(intent);
                            finish();
                        }

                        else
                        {
                            Intent intent = new Intent(SplashActivity.this, SignUpOtp.class);
                            startActivity(intent);
                            finish();
                        }


//                        progressBar.setVisibility(View.GONE);
//                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                        finish();
                    }
                }, SPLASH_SCREEN_TIME_OUT);
            }
        }

        @Override
        public void onBackPressed () {
            super.onBackPressed();
            finish();
        }
    }