package com.zasa.fuellyvendor.models;

import com.google.gson.annotations.SerializedName;



public class App_Detail_Respone_Model {

    @SerializedName("Status")
    private int status;

    @SerializedName("Message")
    private int message;

    @SerializedName("Id")
    private int Id;

    @SerializedName("Coperation")
    private int corporation;

    @SerializedName("App_Id")
    private String appId;

    @SerializedName("App_Title")
    private String appTitle;

    @SerializedName("App_Version")
    private int appVersion;

    @SerializedName("App_Solo")
    private String appSolo;


    @SerializedName("Add_Title")
    private String addTitle;

    @SerializedName("Add_Description")
    private String addDescription;

    @SerializedName("Add_Link")
    private String addLink;

    @SerializedName("Add_Image_Url")
    private String imageUrl;

    @SerializedName("Add_Flag")
    private String addFlag;

    public App_Detail_Respone_Model() {

    }

    public App_Detail_Respone_Model(int status, int message, int id, int corporation, String appId, String appTitle, int appVersion, String appSolo, String addTitle, String addDescription, String addLink, String imageUrl, String addFlag) {
        this.status = status;
        this.message = message;
        Id = id;
        this.corporation = corporation;
        this.appId = appId;
        this.appTitle = appTitle;
        this.appVersion = appVersion;
        this.appSolo = appSolo;
        this.addTitle = addTitle;
        this.addDescription = addDescription;
        this.addLink = addLink;
        this.imageUrl = imageUrl;
        this.addFlag = addFlag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCorporation() {
        return corporation;
    }

    public void setCorporation(int corporation) {
        this.corporation = corporation;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public int getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(int appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppSolo() {
        return appSolo;
    }

    public void setAppSolo(String appSolo) {
        this.appSolo = appSolo;
    }


    public String getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(String addTitle) {
        this.addTitle = addTitle;
    }

    public String getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }

    public String getAddLink() {
        return addLink;
    }

    public void setAddLink(String addLink) {
        this.addLink = addLink;
    }

    public String getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(String addFlag) {
        this.addFlag = addFlag;
    }


   public static class SliderApiModel {
        private String App_ID;
        private String id;
        private int Slider_Serial;
        private int Slider_Title;
        private String Link_Flag;
        private int Coperation;
        private String Slider_Link;
        private String Slider_Image_Url;

        public SliderApiModel() {
        }

        public SliderApiModel(String app_ID, String id, int slider_Serial, int slider_Title, String link_Flag, int coperation, String slider_Link, String slider_Image_Url) {
            App_ID = app_ID;
            this.id = id;
            Slider_Serial = slider_Serial;
            Slider_Title = slider_Title;
            Link_Flag = link_Flag;
            Coperation = coperation;
            Slider_Link = slider_Link;
            Slider_Image_Url = slider_Image_Url;
        }

        public String getApp_ID() {
            return App_ID;
        }

        public void setApp_ID(String app_ID) {
            App_ID = app_ID;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getSlider_Serial() {
            return Slider_Serial;
        }

        public void setSlider_Serial(int slider_Serial) {
            Slider_Serial = slider_Serial;
        }

        public int getSlider_Title() {
            return Slider_Title;
        }

        public void setSlider_Title(int slider_Title) {
            Slider_Title = slider_Title;
        }

        public String getLink_Flag() {
            return Link_Flag;
        }

        public void setLink_Flag(String link_Flag) {
            Link_Flag = link_Flag;
        }

        public int getCoperation() {
            return Coperation;
        }

        public void setCoperation(int coperation) {
            Coperation = coperation;
        }

        public String getSlider_Link() {
            return Slider_Link;
        }

        public void setSlider_Link(String slider_Link) {
            Slider_Link = slider_Link;
        }

        public String getSlider_Image_Url() {
            return Slider_Image_Url;
        }

        public void setSlider_Image_Url(String slider_Image_Url) {
            Slider_Image_Url = slider_Image_Url;}
    }
}


