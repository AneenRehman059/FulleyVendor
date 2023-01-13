package com.zasa.fuellyvendor;

import android.content.Context;
import android.content.SharedPreferences;

import com.zasa.fuellyvendor.AutoLogout.MyApp;

public class PrefsManager {

    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;

    public PrefsManager() {
        preferences = MyApp.context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    public static Boolean IsDarkModeOn() {
        return preferences.getBoolean("IsDarkModeOn", false);
    }
    public static void IsDarkModeOn(Boolean value) {
        editor.putBoolean("IsDarkModeOn", value).commit();
    }

    public static boolean getPin() {
        return preferences.getBoolean("pin", false);
    }

    public static void setPin(Boolean value) {
        editor.putBoolean("pin", value).commit();
    }

}
