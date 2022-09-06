package com.zasa.fuellyvendor.AutoLogout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zasa.fuellyvendor.OTPVerification;

public class BaseActivity extends AppCompatActivity implements LogoutListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApp) getApplication()).registerSessionListener(this);
        ((MyApp) getApplication()).startUserSession();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        ((MyApp) getApplication()).onUserInteracted();
    }

    @Override
    public void onSessionLogout() {
        finish();

        startActivity(new Intent(this, OTPVerification.class));
    }
}
