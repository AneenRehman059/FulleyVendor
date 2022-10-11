package com.zasa.fuellyvendor.models;

import com.google.gson.annotations.SerializedName;

public class Member_Detail_Model {
    @SerializedName("Status")
    private int status;

    @SerializedName("Message")
    private String message;

    @SerializedName("Id")
    private int Id;

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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public class Member_Details {
        @SerializedName("Id")
        private int id;
        @SerializedName("Coperation")
        private int coperation;
        @SerializedName("System_Id")
        private int system_id;
        @SerializedName("str_System_Id")
        private int str_system_id;
        @SerializedName("Member_Registration_Date")
        private int member_registration_date;
        @SerializedName("Member_Type")
        private int member_type;
        @SerializedName("Member_FName")
        private String member_fname;
        @SerializedName("Member_LName")
        private String member_lname;
        @SerializedName("Member_Password")
        private int member_password;
        @SerializedName("Member_TPIN")
        private int member_tpin;
        @SerializedName("Member_Mobile")
        private int member_mobile;
        @SerializedName("Member_Email")
        private String member_email;
        @SerializedName("Member_CNIC")
        private int member_cnic;
        @SerializedName("Member_Linked_Company")
        private int member_linked_company;
        @SerializedName("Company_Employee_Code")
        private int company_employee_code;
        @SerializedName("Member_Fuel_Limit")
        private int member_fuel_limit;
        @SerializedName("Member_Lube_Limit")
        private int member_lube_limit;
        @SerializedName("Member_Service_Limit")
        private int member_service_limit;
        @SerializedName("Company_Fuel_Limit")
        private int company_fuel_limit;
        @SerializedName("Company_Lube_Limit")
        private int company_lube_limit;

        @SerializedName("Company_Service_Limit")
        private int company_service_limit;
        @SerializedName("Company_Limit_Type")
        private String company_limit_type;
        @SerializedName("Balance_Fuel_Limit")
        private int balance_fuel_limit;
        @SerializedName("Balance_Lube_Limit")
        private int balance_lube_limit;
        @SerializedName("Balance_Service_Limit")
        private int balance_service_limit;

        @SerializedName("Member_IsActive")
        private int member_Isactive;
        @SerializedName("Mobile_Verified")
        private int mobile_verified;
        @SerializedName("Email_Verified")
        private int email_verified;
        @SerializedName("UM_User_Id")
        private int um_user_id;

        public Member_Details(int id, int coperation, int system_id, int str_system_id, int member_registration_date, int member_type, String member_fname, String member_lname, int member_password, int member_tpin, int member_mobile, String member_email, int member_cnic, int member_linked_company, int company_employee_code, int member_fuel_limit, int member_lube_limit, int member_service_limit, int company_fuel_limit, int company_lube_limit, int company_service_limit, String company_limit_type, int balance_fuel_limit, int balance_lube_limit, int balance_service_limit, int member_Isactive, int mobile_verified, int email_verified, int um_user_id) {
            this.id = id;
            this.coperation = coperation;
            this.system_id = system_id;
            this.str_system_id = str_system_id;
            this.member_registration_date = member_registration_date;
            this.member_type = member_type;
            this.member_fname = member_fname;
            this.member_lname = member_lname;
            this.member_password = member_password;
            this.member_tpin = member_tpin;
            this.member_mobile = member_mobile;
            this.member_email = member_email;
            this.member_cnic = member_cnic;
            this.member_linked_company = member_linked_company;
            this.company_employee_code = company_employee_code;
            this.member_fuel_limit = member_fuel_limit;
            this.member_lube_limit = member_lube_limit;
            this.member_service_limit = member_service_limit;
            this.company_fuel_limit = company_fuel_limit;
            this.company_lube_limit = company_lube_limit;
            this.company_service_limit = company_service_limit;
            this.company_limit_type = company_limit_type;
            this.balance_fuel_limit = balance_fuel_limit;
            this.balance_lube_limit = balance_lube_limit;
            this.balance_service_limit = balance_service_limit;
            this.member_Isactive = member_Isactive;
            this.mobile_verified = mobile_verified;
            this.email_verified = email_verified;
            this.um_user_id = um_user_id;
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

        public int getSystem_id() {
            return system_id;
        }

        public void setSystem_id(int system_id) {
            this.system_id = system_id;
        }

        public int getStr_system_id() {
            return str_system_id;
        }

        public void setStr_system_id(int str_system_id) {
            this.str_system_id = str_system_id;
        }

        public int getMember_registration_date() {
            return member_registration_date;
        }

        public void setMember_registration_date(int member_registration_date) {
            this.member_registration_date = member_registration_date;
        }

        public int getMember_type() {
            return member_type;
        }

        public void setMember_type(int member_type) {
            this.member_type = member_type;
        }

        public String getMember_fname() {
            return member_fname;
        }

        public void setMember_fname(String member_fname) {
            this.member_fname = member_fname;
        }

        public String getMember_lname() {
            return member_lname;
        }

        public void setMember_lname(String member_lname) {
            this.member_lname = member_lname;
        }

        public int getMember_password() {
            return member_password;
        }

        public void setMember_password(int member_password) {
            this.member_password = member_password;
        }

        public int getMember_tpin() {
            return member_tpin;
        }

        public void setMember_tpin(int member_tpin) {
            this.member_tpin = member_tpin;
        }

        public int getMember_mobile() {
            return member_mobile;
        }

        public void setMember_mobile(int member_mobile) {
            this.member_mobile = member_mobile;
        }

        public String getMember_email() {
            return member_email;
        }

        public void setMember_email(String member_email) {
            this.member_email = member_email;
        }

        public int getMember_cnic() {
            return member_cnic;
        }

        public void setMember_cnic(int member_cnic) {
            this.member_cnic = member_cnic;
        }

        public int getMember_linked_company() {
            return member_linked_company;
        }

        public void setMember_linked_company(int member_linked_company) {
            this.member_linked_company = member_linked_company;
        }

        public int getCompany_employee_code() {
            return company_employee_code;
        }

        public void setCompany_employee_code(int company_employee_code) {
            this.company_employee_code = company_employee_code;
        }

        public int getMember_fuel_limit() {
            return member_fuel_limit;
        }

        public void setMember_fuel_limit(int member_fuel_limit) {
            this.member_fuel_limit = member_fuel_limit;
        }

        public int getMember_lube_limit() {
            return member_lube_limit;
        }

        public void setMember_lube_limit(int member_lube_limit) {
            this.member_lube_limit = member_lube_limit;
        }

        public int getMember_service_limit() {
            return member_service_limit;
        }

        public void setMember_service_limit(int member_service_limit) {
            this.member_service_limit = member_service_limit;
        }

        public int getCompany_fuel_limit() {
            return company_fuel_limit;
        }

        public void setCompany_fuel_limit(int company_fuel_limit) {
            this.company_fuel_limit = company_fuel_limit;
        }

        public int getCompany_lube_limit() {
            return company_lube_limit;
        }

        public void setCompany_lube_limit(int company_lube_limit) {
            this.company_lube_limit = company_lube_limit;
        }

        public int getCompany_service_limit() {
            return company_service_limit;
        }

        public void setCompany_service_limit(int company_service_limit) {
            this.company_service_limit = company_service_limit;
        }

        public String getCompany_limit_type() {
            return company_limit_type;
        }

        public void setCompany_limit_type(String company_limit_type) {
            this.company_limit_type = company_limit_type;
        }

        public int getBalance_fuel_limit() {
            return balance_fuel_limit;
        }

        public void setBalance_fuel_limit(int balance_fuel_limit) {
            this.balance_fuel_limit = balance_fuel_limit;
        }

        public int getBalance_lube_limit() {
            return balance_lube_limit;
        }

        public void setBalance_lube_limit(int balance_lube_limit) {
            this.balance_lube_limit = balance_lube_limit;
        }

        public int getBalance_service_limit() {
            return balance_service_limit;
        }

        public void setBalance_service_limit(int balance_service_limit) {
            this.balance_service_limit = balance_service_limit;
        }

        public int getMember_Isactive() {
            return member_Isactive;
        }

        public void setMember_Isactive(int member_Isactive) {
            this.member_Isactive = member_Isactive;
        }

        public int getMobile_verified() {
            return mobile_verified;
        }

        public void setMobile_verified(int mobile_verified) {
            this.mobile_verified = mobile_verified;
        }

        public int getEmail_verified() {
            return email_verified;
        }

        public void setEmail_verified(int email_verified) {
            this.email_verified = email_verified;
        }

        public int getUm_user_id() {
            return um_user_id;
        }

        public void setUm_user_id(int um_user_id) {
            this.um_user_id = um_user_id;
        }
    }

    public class Member_List{

    }

}
