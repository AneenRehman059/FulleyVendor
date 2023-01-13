package com.zasa.fuellyvendor.models;

import com.google.gson.annotations.SerializedName;

public class GetQrData_Model {

    private String id;

    private String Status;

    private String Message;
    public QR_Detail_Model QR_Details;
    public QRList QR_List = null;

    public GetQrData_Model(String id, String status, String message, QR_Detail_Model QR_Details) {
        this.id = id;
        Status = status;
        Message = message;
        this.QR_Details = QR_Details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public QR_Detail_Model getQR_Details() {
        return QR_Details;
    }

    public void setQR_Details(QR_Detail_Model QR_Details) {
        this.QR_Details = QR_Details;
    }

    public class QR_Detail_Model {

        private String id;

        private int Coperation;

        private String QR_Id;

        private int QR_Type;

        private int QR_Expiry;

        private String QR_Generated_On;

        private String QR_Expired_On;

        private String Member_System_Id;

        private String Member_Linked_Company;

        private String Member_FName;

        private String Member_LName;

        private String Member_Mobile;

        private int Pro_Type_Code;

        private int Pro_Code;

        private String Company_Code;

        private String Fix_Pump_Code;

        private float Fuel_Limit;

        private String Pump_Code;

        private float Actual_Fuel;

        private float Fuel_Rate;

        private float Fuel_Amount;

        private String Fleet_Code;

        private String Fuel_Up_Lat;

        private String Fuel_Up_Long;

        private String Fuel_Up_Location;
        private int Payment_Type;

        private int Payment_Status;

        private String Settelment_Id;

        private String UM_User_Id;

        public QR_Detail_Model(String id, int coperation, String QR_Id, int QR_Type, int QR_Expiry, String QR_Generated_On, String QR_Expired_On, String member_System_Id, String member_Linked_Company, String member_FName, String member_LName, String member_Mobile, int pro_Type_Code, int pro_Code, String company_Code, String fix_Pump_Code, float fuel_Limit, String pump_Code, float actual_Fuel, float fuel_Rate, float fuel_Amount, String fleet_Code, String fuel_Up_Lat, String fuel_Up_Long, String fuel_Up_Location, int payment_Type, int payment_Status, String settelment_Id, String UM_User_Id) {
            this.id = id;
            Coperation = coperation;
            this.QR_Id = QR_Id;
            this.QR_Type = QR_Type;
            this.QR_Expiry = QR_Expiry;
            this.QR_Generated_On = QR_Generated_On;
            this.QR_Expired_On = QR_Expired_On;
            Member_System_Id = member_System_Id;
            Member_Linked_Company = member_Linked_Company;
            Member_FName = member_FName;
            Member_LName = member_LName;
            Member_Mobile = member_Mobile;
            Pro_Type_Code = pro_Type_Code;
            Pro_Code = pro_Code;
            Company_Code = company_Code;
            Fix_Pump_Code = fix_Pump_Code;
            Fuel_Limit = fuel_Limit;
            Pump_Code = pump_Code;
            Actual_Fuel = actual_Fuel;
            Fuel_Rate = fuel_Rate;
            Fuel_Amount = fuel_Amount;
            Fleet_Code = fleet_Code;
            Fuel_Up_Lat = fuel_Up_Lat;
            Fuel_Up_Long = fuel_Up_Long;
            Fuel_Up_Location = fuel_Up_Location;
            Payment_Type = payment_Type;
            Payment_Status = payment_Status;
            Settelment_Id = settelment_Id;
            this.UM_User_Id = UM_User_Id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCoperation() {
            return Coperation;
        }

        public void setCoperation(int coperation) {
            Coperation = coperation;
        }

        public String getQR_Id() {
            return QR_Id;
        }

        public void setQR_Id(String QR_Id) {
            this.QR_Id = QR_Id;
        }

        public int getQR_Type() {
            return QR_Type;
        }

        public void setQR_Type(int QR_Type) {
            this.QR_Type = QR_Type;
        }

        public int getQR_Expiry() {
            return QR_Expiry;
        }

        public void setQR_Expiry(int QR_Expiry) {
            this.QR_Expiry = QR_Expiry;
        }

        public String getQR_Generated_On() {
            return QR_Generated_On;
        }

        public void setQR_Generated_On(String QR_Generated_On) {
            this.QR_Generated_On = QR_Generated_On;
        }

        public String getQR_Expired_On() {
            return QR_Expired_On;
        }

        public void setQR_Expired_On(String QR_Expired_On) {
            this.QR_Expired_On = QR_Expired_On;
        }

        public String getMember_System_Id() {
            return Member_System_Id;
        }

        public void setMember_System_Id(String member_System_Id) {
            Member_System_Id = member_System_Id;
        }

        public String getMember_Linked_Company() {
            return Member_Linked_Company;
        }

        public void setMember_Linked_Company(String member_Linked_Company) {
            Member_Linked_Company = member_Linked_Company;
        }

        public String getMember_FName() {
            return Member_FName;
        }

        public void setMember_FName(String member_FName) {
            Member_FName = member_FName;
        }

        public String getMember_LName() {
            return Member_LName;
        }

        public void setMember_LName(String member_LName) {
            Member_LName = member_LName;
        }

        public String getMember_Mobile() {
            return Member_Mobile;
        }

        public void setMember_Mobile(String member_Mobile) {
            Member_Mobile = member_Mobile;
        }

        public int getPro_Type_Code() {
            return Pro_Type_Code;
        }

        public void setPro_Type_Code(int pro_Type_Code) {
            Pro_Type_Code = pro_Type_Code;
        }

        public int getPro_Code() {
            return Pro_Code;
        }

        public void setPro_Code(int pro_Code) {
            Pro_Code = pro_Code;
        }

        public String getCompany_Code() {
            return Company_Code;
        }

        public void setCompany_Code(String company_Code) {
            Company_Code = company_Code;
        }

        public String getFix_Pump_Code() {
            return Fix_Pump_Code;
        }

        public void setFix_Pump_Code(String fix_Pump_Code) {
            Fix_Pump_Code = fix_Pump_Code;
        }

        public float getFuel_Limit() {
            return Fuel_Limit;
        }

        public void setFuel_Limit(float fuel_Limit) {
            Fuel_Limit = fuel_Limit;
        }

        public String getPump_Code() {
            return Pump_Code;
        }

        public void setPump_Code(String pump_Code) {
            Pump_Code = pump_Code;
        }

        public float getActual_Fuel() {
            return Actual_Fuel;
        }

        public void setActual_Fuel(float actual_Fuel) {
            Actual_Fuel = actual_Fuel;
        }

        public float getFuel_Rate() {
            return Fuel_Rate;
        }

        public void setFuel_Rate(float fuel_Rate) {
            Fuel_Rate = fuel_Rate;
        }

        public float getFuel_Amount() {
            return Fuel_Amount;
        }

        public void setFuel_Amount(float fuel_Amount) {
            Fuel_Amount = fuel_Amount;
        }

        public String getFleet_Code() {
            return Fleet_Code;
        }

        public void setFleet_Code(String fleet_Code) {
            Fleet_Code = fleet_Code;
        }

        public String getFuel_Up_Lat() {
            return Fuel_Up_Lat;
        }

        public void setFuel_Up_Lat(String fuel_Up_Lat) {
            Fuel_Up_Lat = fuel_Up_Lat;
        }

        public String getFuel_Up_Long() {
            return Fuel_Up_Long;
        }

        public void setFuel_Up_Long(String fuel_Up_Long) {
            Fuel_Up_Long = fuel_Up_Long;
        }

        public String getFuel_Up_Location() {
            return Fuel_Up_Location;
        }

        public void setFuel_Up_Location(String fuel_Up_Location) {
            Fuel_Up_Location = fuel_Up_Location;
        }

        public int getPayment_Type() {
            return Payment_Type;
        }

        public void setPayment_Type(int payment_Type) {
            Payment_Type = payment_Type;
        }

        public int getPayment_Status() {
            return Payment_Status;
        }

        public void setPayment_Status(int payment_Status) {
            Payment_Status = payment_Status;
        }

        public String getSettelment_Id() {
            return Settelment_Id;
        }

        public void setSettelment_Id(String settelment_Id) {
            Settelment_Id = settelment_Id;
        }

        public String getUM_User_Id() {
            return UM_User_Id;
        }

        public void setUM_User_Id(String UM_User_Id) {
            this.UM_User_Id = UM_User_Id;
        }
    }

    public class QRList {
    }
}
