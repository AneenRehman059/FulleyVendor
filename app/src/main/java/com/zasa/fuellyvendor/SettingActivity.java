package com.zasa.fuellyvendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zasa.fuellyvendor.Login.LoginActivity;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    TextView appVersion, tvUsername, notfication, subNoti, changePass, subchangePass, biometric, sub_biometric, appTheme, subApptheme, lgout, sublogout;
    LinearLayout change_pass;
    LinearLayout check_notification, biometricLogin , changeTheme ;
    LinearLayout logout, layout1, layout2, layout3, layout4, layout5;
    LinearLayoutCompat settingLayout;
    SwitchCompat is_biometric, modeSwitch;
    RelativeLayout lay1;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        getid();
        check_biometric();
        checkDarMode();
        setDarkMode();


//        int versionCode = BuildConfig.VERSION_CODE;
//        String versionName = BuildConfig.VERSION_NAME;
////        appVersion.setText("App Version:" + versionName);
////        Toast.makeText(getContext(), "version" + versionName, Toast.LENGTH_SHORT).show();

        check_notification.setOnClickListener(this);
        change_pass.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    private void getid() {
//        appVersion = view.findViewById(R.id.version);
        backBtn = findViewById(R.id.m1);
        biometricLogin = findViewById(R.id.biometric);
        changeTheme = findViewById(R.id.themeChange);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        lay1 = findViewById(R.id.lay1);
        change_pass = findViewById(R.id.reset_pass);
        check_notification = findViewById(R.id.notification);
        logout = findViewById(R.id.logout);
        is_biometric = findViewById(R.id.is_biometric);
        modeSwitch = findViewById(R.id.check_mode);
        settingLayout = findViewById(R.id.setting_layout);
        tvUsername = findViewById(R.id.tvSetting);
        changePass = findViewById(R.id.tv_changePassword);
        subchangePass = findViewById(R.id.subchangePass);
        notfication = findViewById(R.id.tvNotification);
        subNoti = findViewById(R.id.subNotification);
        biometric = findViewById(R.id.tvBiometric);
        sub_biometric = findViewById(R.id.subBiometric);
        appTheme = findViewById(R.id.tvApptheme);
        subApptheme = findViewById(R.id.subApptheme);
        lgout = findViewById(R.id.tvLogout);
        sublogout = findViewById(R.id.subLogout);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.notification) {
            Intent intent = new Intent(SettingActivity.this, NotificationHere.class);
            startActivity(intent);
        } else if (v.getId() == R.id.reset_pass) {
            Intent intent = new Intent(SettingActivity.this, Change_Tpin_Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.logout) {
            startActivity(new Intent(SettingActivity.this, LoginActivity.class));
            SettingActivity.this.onBackPressed();
        }
    }

    private void check_biometric() {
        SharedPreferences sharedPreferences = SettingActivity.this.getSharedPreferences("save", Context.MODE_PRIVATE);
        is_biometric.setChecked(sharedPreferences.getBoolean("value", false));
        is_biometric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (is_biometric.isChecked()) {
                    SharedPreferences.Editor editor = SettingActivity.this.getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    is_biometric.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = SettingActivity.this.getSharedPreferences("save",
                            Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    is_biometric.setChecked(false);
                }
            }
        });
    }

    private void checkDarMode() {
        modeSwitch.setChecked(PrefsManager.IsDarkModeOn());
        modeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modeSwitch.isChecked()) {
                    modeSwitch.setChecked(true);
                    Toast.makeText(SettingActivity.this, "Mode On", Toast.LENGTH_SHORT).show();
                    PrefsManager.IsDarkModeOn(true);
                    setDarkMode();
                } else {
                    modeSwitch.setChecked(false);
                    Toast.makeText(SettingActivity.this, "Mode Of", Toast.LENGTH_SHORT).show();
                    PrefsManager.IsDarkModeOn(false);
                    setDarkMode();
                }
            }
        });
    }

    private void setDarkMode() {
        Helper.setDarkModeOnOff(SettingActivity.this, settingLayout);

        if (PrefsManager.IsDarkModeOn()) {

            logout.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            biometricLogin.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            changeTheme.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            check_notification.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            change_pass.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            lay1.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            backBtn.setColorFilter(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            tvUsername.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            changePass.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            subchangePass.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            notfication.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            subNoti.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            biometric.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            sub_biometric.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            appTheme.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            subApptheme.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            lgout.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            sublogout.setTextColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
        }
        else {
            logout.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            biometricLogin.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            changeTheme.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            check_notification.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            change_pass.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            lay1.setBackgroundColor(SettingActivity.this.getResources().getColor(R.color.white, SettingActivity.this.getTheme()));
            backBtn.setColorFilter(SettingActivity.this.getResources().getColor(R.color.primary, SettingActivity.this.getTheme()));
            tvUsername.setTextColor(SettingActivity.this.getResources().getColor(R.color.primary, SettingActivity.this.getTheme()));
            changePass.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            subchangePass.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            notfication.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            subNoti.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            biometric.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            sub_biometric.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            appTheme.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            subApptheme.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            lgout.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
            sublogout.setTextColor(SettingActivity.this.getResources().getColor(R.color.black, SettingActivity.this.getTheme()));
        }
    }
}