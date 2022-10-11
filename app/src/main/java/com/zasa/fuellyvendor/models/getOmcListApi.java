package com.zasa.fuellyvendor.models;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
@Keep
public class getOmcListApi {

    private String id;
    private int Status;
    private String Message;
    private String OMC_Details = null;
    @SerializedName("OMC_List")
    ArrayList<OMC_List> OMC_List = new ArrayList<>();

    public getOmcListApi(String id, int status, String message, String OMC_Details, ArrayList<OMC_List> OMC_List) {
        this.id = id;
        Status = status;
        Message = message;
        this.OMC_Details = OMC_Details;
        this.OMC_List = OMC_List;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getOMC_Details() {
        return OMC_Details;
    }

    public void setOMC_Details(String OMC_Details) {
        this.OMC_Details = OMC_Details;
    }

    public ArrayList<getOmcListApi.OMC_List> getOMC_List() {
        return OMC_List;
    }

    public void setOMC_List(ArrayList<getOmcListApi.OMC_List> OMC_List) {
        this.OMC_List = OMC_List;
    }

    public class OMC_List {
        private String id;
        private String Coperation;
        private String OMC_Code;
        private String strOMC_Code;
        private String OMC_TPIN;
        private String OMC_Title;
        private String OMC_Address;
        private String OMC_NTN;
        private String OMC_STN;
        private String OMC_Email;
        private String OMC_Website;
        private String OMC_Bank_Name;
        private String OMC_Account_Number;
        private String OMC_Account_Title;
        private String OMC_Phone_Number;
        private String OMC_Fax_Number;
        private String OMC_Contact_Person;
        private String OMC_Contact_Person_Phone;
        private String OMC_Contact_Person_Email;
        private String OMC_User_Id;
        private String OMC_User_Password;
        private int OMC_IsActive;
        private String UM_User_Id;

        public OMC_List(String id, String coperation, String OMC_Code, String strOMC_Code, String OMC_TPIN, String OMC_Title, String OMC_Address, String OMC_NTN, String OMC_STN, String OMC_Email, String OMC_Website, String OMC_Bank_Name, String OMC_Account_Number, String OMC_Account_Title, String OMC_Phone_Number, String OMC_Fax_Number, String OMC_Contact_Person, String OMC_Contact_Person_Phone, String OMC_Contact_Person_Email, String OMC_User_Id, String OMC_User_Password, int OMC_IsActive, String UM_User_Id) {
            this.id = id;
            Coperation = coperation;
            this.OMC_Code = OMC_Code;
            this.strOMC_Code = strOMC_Code;
            this.OMC_TPIN = OMC_TPIN;
            this.OMC_Title = OMC_Title;
            this.OMC_Address = OMC_Address;
            this.OMC_NTN = OMC_NTN;
            this.OMC_STN = OMC_STN;
            this.OMC_Email = OMC_Email;
            this.OMC_Website = OMC_Website;
            this.OMC_Bank_Name = OMC_Bank_Name;
            this.OMC_Account_Number = OMC_Account_Number;
            this.OMC_Account_Title = OMC_Account_Title;
            this.OMC_Phone_Number = OMC_Phone_Number;
            this.OMC_Fax_Number = OMC_Fax_Number;
            this.OMC_Contact_Person = OMC_Contact_Person;
            this.OMC_Contact_Person_Phone = OMC_Contact_Person_Phone;
            this.OMC_Contact_Person_Email = OMC_Contact_Person_Email;
            this.OMC_User_Id = OMC_User_Id;
            this.OMC_User_Password = OMC_User_Password;
            this.OMC_IsActive = OMC_IsActive;
            this.UM_User_Id = UM_User_Id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCoperation() {
            return Coperation;
        }

        public void setCoperation(String coperation) {
            Coperation = coperation;
        }

        public String getOMC_Code() {
            return OMC_Code;
        }

        public void setOMC_Code(String OMC_Code) {
            this.OMC_Code = OMC_Code;
        }

        public String getStrOMC_Code() {
            return strOMC_Code;
        }

        public void setStrOMC_Code(String strOMC_Code) {
            this.strOMC_Code = strOMC_Code;
        }

        public String getOMC_TPIN() {
            return OMC_TPIN;
        }

        public void setOMC_TPIN(String OMC_TPIN) {
            this.OMC_TPIN = OMC_TPIN;
        }

        public String getOMC_Title() {
            return OMC_Title;
        }

        public void setOMC_Title(String OMC_Title) {
            this.OMC_Title = OMC_Title;
        }

        public String getOMC_Address() {
            return OMC_Address;
        }

        public void setOMC_Address(String OMC_Address) {
            this.OMC_Address = OMC_Address;
        }

        public String getOMC_NTN() {
            return OMC_NTN;
        }

        public void setOMC_NTN(String OMC_NTN) {
            this.OMC_NTN = OMC_NTN;
        }

        public String getOMC_STN() {
            return OMC_STN;
        }

        public void setOMC_STN(String OMC_STN) {
            this.OMC_STN = OMC_STN;
        }

        public String getOMC_Email() {
            return OMC_Email;
        }

        public void setOMC_Email(String OMC_Email) {
            this.OMC_Email = OMC_Email;
        }

        public String getOMC_Website() {
            return OMC_Website;
        }

        public void setOMC_Website(String OMC_Website) {
            this.OMC_Website = OMC_Website;
        }

        public String getOMC_Bank_Name() {
            return OMC_Bank_Name;
        }

        public void setOMC_Bank_Name(String OMC_Bank_Name) {
            this.OMC_Bank_Name = OMC_Bank_Name;
        }

        public String getOMC_Account_Number() {
            return OMC_Account_Number;
        }

        public void setOMC_Account_Number(String OMC_Account_Number) {
            this.OMC_Account_Number = OMC_Account_Number;
        }

        public String getOMC_Account_Title() {
            return OMC_Account_Title;
        }

        public void setOMC_Account_Title(String OMC_Account_Title) {
            this.OMC_Account_Title = OMC_Account_Title;
        }

        public String getOMC_Phone_Number() {
            return OMC_Phone_Number;
        }

        public void setOMC_Phone_Number(String OMC_Phone_Number) {
            this.OMC_Phone_Number = OMC_Phone_Number;
        }

        public String getOMC_Fax_Number() {
            return OMC_Fax_Number;
        }

        public void setOMC_Fax_Number(String OMC_Fax_Number) {
            this.OMC_Fax_Number = OMC_Fax_Number;
        }

        public String getOMC_Contact_Person() {
            return OMC_Contact_Person;
        }

        public void setOMC_Contact_Person(String OMC_Contact_Person) {
            this.OMC_Contact_Person = OMC_Contact_Person;
        }

        public String getOMC_Contact_Person_Phone() {
            return OMC_Contact_Person_Phone;
        }

        public void setOMC_Contact_Person_Phone(String OMC_Contact_Person_Phone) {
            this.OMC_Contact_Person_Phone = OMC_Contact_Person_Phone;
        }

        public String getOMC_Contact_Person_Email() {
            return OMC_Contact_Person_Email;
        }

        public void setOMC_Contact_Person_Email(String OMC_Contact_Person_Email) {
            this.OMC_Contact_Person_Email = OMC_Contact_Person_Email;
        }

        public String getOMC_User_Id() {
            return OMC_User_Id;
        }

        public void setOMC_User_Id(String OMC_User_Id) {
            this.OMC_User_Id = OMC_User_Id;
        }

        public String getOMC_User_Password() {
            return OMC_User_Password;
        }

        public void setOMC_User_Password(String OMC_User_Password) {
            this.OMC_User_Password = OMC_User_Password;
        }

        public int getOMC_IsActive() {
            return OMC_IsActive;
        }

        public void setOMC_IsActive(int OMC_IsActive) {
            this.OMC_IsActive = OMC_IsActive;
        }

        public String getUM_User_Id() {
            return UM_User_Id;
        }

        public void setUM_User_Id(String UM_User_Id) {
            this.UM_User_Id = UM_User_Id;
        }

    }
    }