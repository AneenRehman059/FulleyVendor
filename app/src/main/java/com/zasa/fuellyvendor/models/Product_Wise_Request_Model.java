package com.zasa.fuellyvendor.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product_Wise_Request_Model {
    @SerializedName("App_id")
    private int app_id;

    @SerializedName("Status")
    private int status;

    @SerializedName("Message")
    private String message;

    @SerializedName("id")
    private int id;

    @SerializedName("Coperation")
    private int coperation;

    @SerializedName("Pro_Code")
    private int pro_code;

    @SerializedName("Pro_Title")
    private String pro_title;

    @SerializedName("Pro_Type_Code")
    private int pro_type_code;

    @SerializedName("Pro_Price")
    private int pro_price;

    public Product_Wise_Request_Model(int app_id, int status, String message, int id, int coperation, int pro_code, String pro_title, int pro_type_code, int pro_price) {
        this.app_id = app_id;
        this.status = status;
        this.message = message;
        this.id = id;
        this.coperation = coperation;
        this.pro_code = pro_code;
        this.pro_title = pro_title;
        this.pro_type_code = pro_type_code;
        this.pro_price = pro_price;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCoperation() {
            return coperation;
        }

        public void setCoperation(int coperation) {
            this.coperation = coperation;
        }

        public int getPro_code() {
            return pro_code;
        }

        public void setPro_code(int pro_code) {
            this.pro_code = pro_code;
        }

        public String getPro_title() {
            return pro_title;
        }

        public void setPro_title(String pro_title) {
            this.pro_title = pro_title;
        }

        public int getPro_type_code() {
            return pro_type_code;
        }

        public void setPro_type_code(int pro_type_code) {
            this.pro_type_code = pro_type_code;
        }

        public int getPro_price() {
            return pro_price;
        }

        public void setPro_price(int pro_price) {
            this.pro_price = pro_price;
        }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

