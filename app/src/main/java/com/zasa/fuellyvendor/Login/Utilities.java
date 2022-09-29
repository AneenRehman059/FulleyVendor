package com.zasa.fuellyvendor.Login;

import android.content.Context;
import android.content.SharedPreferences;

public class Utilities {

    private final static String STRING_PREFERENCES = "StringPreferences";
    private final static String BOOLEAN_PREFERENCES = "BooleanPreferences";
    private final static String INTEGER_PREFERENCES = "IntegerPreferences";

//    public static void clearLogoutSharedPreferences(Context mContext) {
//        SharedPreferences registerSharedpreferences = mContext.getSharedPreferences(Constants.PREFS_REGISTER, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = registerSharedpreferences.edit();
//        editor.clear().apply();
//
//        SharedPreferences loginSharedpreferences = mContext.getSharedPreferences(Constants.PREF_IS_USER_LOGIN, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor2 = loginSharedpreferences.edit();
//        editor2.clear().apply();
//    }

    public static void clearAllSharedPreferences(Context mContext) {
//        SharedPreferences registerSharedpreferences = mContext.getSharedPreferences(Constants.PREFS_REGISTER, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = registerSharedpreferences.edit();
//        editor.clear().apply();

//        SharedPreferences loginSharedpreferences = mContext.getSharedPreferences(Constants.PREF_IS_USER_LOGIN, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor2 = loginSharedpreferences.edit();
//        editor2.clear().apply();

        SharedPreferences booleanSharedpreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = booleanSharedpreferences.edit();
        editor3.clear().apply();

        SharedPreferences stringSharedpreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4 = stringSharedpreferences.edit();
        editor4.clear().apply();
        editor3.clear().apply();

        SharedPreferences integerSharedpreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor5 = integerSharedpreferences.edit();
        editor5.clear().apply();
    }

    public static void saveBooleanPreferences(Context mContext, String key, boolean value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBooleanPreferences(Context mContext, String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(BOOLEAN_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean(key, false);
    }

    public static String getStringPreferences(Context mContext, String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(key, "");
    }

    public static void saveStringPreferences(Context mContext, String key, String value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(STRING_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveIntegerPreferences(Context mContext, String key, int value) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getIntegerPreferences(Context mContext, String key) {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences(INTEGER_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getInt(key, 0);
    }

    public static float pxFromDp(Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}
