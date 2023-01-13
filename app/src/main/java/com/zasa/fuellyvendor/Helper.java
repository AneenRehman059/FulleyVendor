package com.zasa.fuellyvendor;

import android.content.Context;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

public class Helper {
    public static String BASE_URL = "http://fuellyapi.loyaltybunch.com/api/";

    public static void setDarkModeOnOff(Context context, LinearLayoutCompat linearLayoutCompat) {
        if (PrefsManager.IsDarkModeOn()) {
            //  Toast.makeText(context, "dark mode", Toast.LENGTH_SHORT).show();
            linearLayoutCompat.setBackgroundColor(context.getResources().getColor(R.color.black, context.getTheme()));
        } else {
            linearLayoutCompat.setBackground(ContextCompat.getDrawable(context, R.drawable.transparent_background));
        }
    }
}
