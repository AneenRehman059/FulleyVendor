package com.zasa.fuellyvendor.AutoLogout;

import android.app.Application;
import android.content.Context;

import com.zasa.fuellyvendor.PrefsManager;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {

    public static Context context;
    @Override

    public void onCreate() {
        super.onCreate();
        context=this;
        new PrefsManager();

    }
    private LogoutListener listener;
    private Timer timer;

    public void startUserSession() {

        cancelTimer();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onSessionLogout();
            }
        },80000);
    }

    private void cancelTimer() {
        if (timer != null)
            timer.cancel();
    }

    public void registerSessionListener(LogoutListener listener) {
        this.listener = listener;
    }

    public void onUserInteracted() {
        startUserSession();
    }
}
