package com.zasa.fuellyvendor.Utils;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "sharedPref";
    private SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

   /* public void appVersion(AppversionListModel appversion) {

        sharedPreferences = context.getSharedPreferences("AppVersion", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("appId", appversion.getApp_ID());
        editor.putFloat("appVersion", appversion.getApp_Version());
        editor.putString("Web_App_Static", appversion.getWeb_App_Static());
        editor.putString("Msg_Flag", appversion.getMsg_Flag());
        editor.putString("Msg_Title", appversion.getMsg_Title());
        editor.putString("Msg_Desc", appversion.getMsg_Desc());
        editor.putString("Msg_Imag_Link", appversion.getMsg_Imag_Link());
        editor.putString("Hit_Counts", appversion.getHit_Counts());
        editor.apply();

    }*/
//   public void saveDeliveryStatusList(ArrayList<DeliveryStatusListModel> arrayList) {
//       SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//       SharedPreferences.Editor editor = sharedPreferences.edit();
//       Gson gson = new Gson();
//       String json = gson.toJson(arrayList);
//       editor.putString("list", json);
//       editor.apply();
//   }
//
//    public ArrayList<DeliveryStatusListModel> loadDeliveryStatusList() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("list", null);
//        Type type = new TypeToken<ArrayList<DeliveryStatusListModel>>() {
//        }.getType();
//        ArrayList<DeliveryStatusListModel> arrayList = gson.fromJson(json, type);
//        if (arrayList == null) {
//            return arrayList = new ArrayList<>();
//        }
//        return arrayList;
//    }
//
//    public void saveVendor(VendorSingleModel vendor) {
//
//        Gson gson = new Gson();
//        String json = gson.toJson(vendor);
//
//        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("VendorSingleModel", json);
//        editor.putBoolean("logged", true);
//        editor.apply();
//
//    }
//
//    public VendorSingleModel getVendor() {
//
//        Gson gsonRetrieve = new Gson();
//
//        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        String jsonRetrieve = sharedPreferences.getString("VendorSingleModel", null);
//
//        VendorSingleModel vendorSingleModel;
//        if (jsonRetrieve == null) {
//            return null;
//        } else
//            vendorSingleModel = gsonRetrieve.fromJson(jsonRetrieve, VendorSingleModel.class);
//        return vendorSingleModel;
//
//    }

    public void rememberMe(String st_Phone, String st_password) {
        sharedPreferences = context.getSharedPreferences("RememberMe", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("uPhone", st_Phone);
        editor.putString("uPass", st_password);
        editor.apply();
    }

    public boolean isLoggedIn() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged", false);
    }

    public void logout() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
