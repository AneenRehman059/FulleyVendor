package com.zasa.fuellyvendor.Request;

import com.google.gson.annotations.SerializedName;
import com.zasa.fuellyvendor.Response.App_Detail_Respone_Model;

import java.util.ArrayList;

public class App_Detail_Request {
    @SerializedName("App_Id")
    private String app_Id;
    App_Detail_Respone_Model App_Details;
    ArrayList<App_Detail_Respone_Model.SliderApiModel> App_Slider = new ArrayList<>();

    public App_Detail_Request() {

    }

    public App_Detail_Request(String app_Id, App_Detail_Respone_Model app_Details, ArrayList<App_Detail_Respone_Model.SliderApiModel> app_Slider) {
        this.app_Id = app_Id;
        App_Details = app_Details;
        App_Slider = app_Slider;
    }

    public App_Detail_Respone_Model getApp_Details() {
        return App_Details;
    }

    public void setApp_Details(App_Detail_Respone_Model app_Details) {
        App_Details = app_Details;
    }

    public String getApp_Id() {
        return app_Id;
    }

    public void setApp_Id(String app_Id) {
        this.app_Id = app_Id;
    }

    public ArrayList<App_Detail_Respone_Model.SliderApiModel> getApp_Slider() {
        return App_Slider;
    }

    public void setApp_Slider(ArrayList<App_Detail_Respone_Model.SliderApiModel> app_Slider) {
        App_Slider = app_Slider;
    }
}
