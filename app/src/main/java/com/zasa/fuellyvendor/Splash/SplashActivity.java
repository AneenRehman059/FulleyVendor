package com.zasa.fuellyvendor.Splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
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
import com.zasa.fuellyvendor.Login.LoginActivity;
import com.zasa.fuellyvendor.R;
import com.zasa.fuellyvendor.Utils.Internet;
import com.zasa.fuellyvendor.Utils.SharedPrefManager;

public class SplashActivity extends AppCompatActivity {


    AppUpdateManager appUpdateManager;
    public static final int RC_APP_UPDATEE = 104;

    private static final long SPLASH_SCREEN_TIME_OUT = 2000;//3sec
    Context context;
    ProgressBar progressBar;
    SharedPrefManager sharedPrefManager;
    boolean isHandlerRun = true;


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
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
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