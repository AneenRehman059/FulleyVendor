package com.zasa.fuellyvendor.models;

import com.google.gson.annotations.SerializedName;

public class Member_Detail_Model {
    @SerializedName("Status")
    private String status;

    @SerializedName("Message")
    private String message;

    @SerializedName("id")
    private String Id;

    public GetPump_Details Pump_Details;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public GetPump_Details getPump_Details() {
        return Pump_Details;
    }

    public void setPump_Details(GetPump_Details pump_Details) {
        Pump_Details = pump_Details;
    }

    public class GetPump_Details {
        @SerializedName("id")
        private String id;
        @SerializedName("Coperation")
        private int coperation;
        @SerializedName("Pump_Code")
        private String pump_code;
        @SerializedName("strPump_Code")
        private String strPump_code;
        @SerializedName("Pump_TPIN")
        private String pump_tpin;
        @SerializedName("Pump_Title")
        private String pump_title;
        @SerializedName("Pump_Address")
        private String pump_address;
        @SerializedName("Pump_NTN")
        private String pump_ntn;
        @SerializedName("Pump_STN")
        private String pump_stn;
        @SerializedName("Pump_Bank_Name")
        private String pump_bank_name;
        @SerializedName("Pump_Account_Number")
        private String pump_account_number;
        @SerializedName("Pump_Account_Title")
        private String pump_account_title;
        @SerializedName("Pump_Phone_Number")
        private String pump_phone_number;
        @SerializedName("Pump_Fax_Number")
        private String pump_fax_number;
        @SerializedName("Pump_Email")
        private String pump_email;
        @SerializedName("Pump_Website")
        private String pump_website;
        @SerializedName("Pump_Owner_Name")
        private String pump_owner_name;
        @SerializedName("Pump_Owner_Mobile")
        private String pump_owner_mobile;
        @SerializedName("Pump_Owner_Phone")
        private String pump_owner_phone;
        @SerializedName("Pump_Owner_Email")
        private String pump_owner_email;

        @SerializedName("Pump_Manager1_Name")
        private String pump_manager1_name;
        @SerializedName("Pump_Manager1_Phone")
        private String pump_manager1_phone;
        @SerializedName("Pump_Manager1_Email")
        private String pump_manager1_email;
        @SerializedName("Pump_Manager2_Name")
        private String pump_manager2_name;
        @SerializedName("Pump_Manager2_Phone")
        private String pump_manager2_phone;

        @SerializedName("Pump_Manager2_Email")
        private String pump_manager2_email;
        @SerializedName("Pump_Image_String")
        private String pump_image_string;
        @SerializedName("OMC_Code")
        private String omc_code;
        @SerializedName("Company_Operated")
        private int company_operated;
        @SerializedName("Pump_IsActive")
        private int pump_isActive;
        @SerializedName("Pump_Payment_Terms")
        private int pump_payment_terms;
        @SerializedName("Pump_User_Id")
        private String pump_user_id;
        @SerializedName("Pump_User_Password")
        private String pump_user_password;
        @SerializedName("UM_User_Id")
        private String um_user_id;

        public GetPump_Details(String id, int coperation, String pump_code, String strPump_code, String pump_tpin, String pump_title, String pump_address, String pump_ntn, String pump_stn, String pump_bank_name, String pump_account_number, String pump_account_title, String pump_phone_number, String pump_fax_number, String pump_email, String pump_website, String pump_owner_name, String pump_owner_mobile, String pump_owner_phone, String pump_owner_email, String pump_manager1_name, String pump_manager1_phone, String pump_manager1_email, String pump_manager2_name, String pump_manager2_phone, String pump_manager2_email, String pump_image_string, String omc_code, int company_operated, int pump_isActive, int pump_payment_terms, String pump_user_id, String pump_user_password, String um_user_id) {
            this.id = id;
            this.coperation = coperation;
            this.pump_code = pump_code;
            this.strPump_code = strPump_code;
            this.pump_tpin = pump_tpin;
            this.pump_title = pump_title;
            this.pump_address = pump_address;
            this.pump_ntn = pump_ntn;
            this.pump_stn = pump_stn;
            this.pump_bank_name = pump_bank_name;
            this.pump_account_number = pump_account_number;
            this.pump_account_title = pump_account_title;
            this.pump_phone_number = pump_phone_number;
            this.pump_fax_number = pump_fax_number;
            this.pump_email = pump_email;
            this.pump_website = pump_website;
            this.pump_owner_name = pump_owner_name;
            this.pump_owner_mobile = pump_owner_mobile;
            this.pump_owner_phone = pump_owner_phone;
            this.pump_owner_email = pump_owner_email;
            this.pump_manager1_name = pump_manager1_name;
            this.pump_manager1_phone = pump_manager1_phone;
            this.pump_manager1_email = pump_manager1_email;
            this.pump_manager2_name = pump_manager2_name;
            this.pump_manager2_phone = pump_manager2_phone;
            this.pump_manager2_email = pump_manager2_email;
            this.pump_image_string = pump_image_string;
            this.omc_code = omc_code;
            this.company_operated = company_operated;
            this.pump_isActive = pump_isActive;
            this.pump_payment_terms = pump_payment_terms;
            this.pump_user_id = pump_user_id;
            this.pump_user_password = pump_user_password;
            this.um_user_id = um_user_id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCoperation() {
            return coperation;
        }

        public void setCoperation(int coperation) {
            this.coperation = coperation;
        }

        public String getPump_code() {
            return pump_code;
        }

        public void setPump_code(String pump_code) {
            this.pump_code = pump_code;
        }

        public String getStrPump_code() {
            return strPump_code;
        }

        public void setStrPump_code(String strPump_code) {
            this.strPump_code = strPump_code;
        }

        public String getPump_tpin() {
            return pump_tpin;
        }

        public void setPump_tpin(String pump_tpin) {
            this.pump_tpin = pump_tpin;
        }

        public String getPump_title() {
            return pump_title;
        }

        public void setPump_title(String pump_title) {
            this.pump_title = pump_title;
        }

        public String getPump_address() {
            return pump_address;
        }

        public void setPump_address(String pump_address) {
            this.pump_address = pump_address;
        }

        public String getPump_ntn() {
            return pump_ntn;
        }

        public void setPump_ntn(String pump_ntn) {
            this.pump_ntn = pump_ntn;
        }

        public String getPump_stn() {
            return pump_stn;
        }

        public void setPump_stn(String pump_stn) {
            this.pump_stn = pump_stn;
        }

        public String getPump_bank_name() {
            return pump_bank_name;
        }

        public void setPump_bank_name(String pump_bank_name) {
            this.pump_bank_name = pump_bank_name;
        }

        public String getPump_account_number() {
            return pump_account_number;
        }

        public void setPump_account_number(String pump_account_number) {
            this.pump_account_number = pump_account_number;
        }

        public String getPump_account_title() {
            return pump_account_title;
        }

        public void setPump_account_title(String pump_account_title) {
            this.pump_account_title = pump_account_title;
        }

        public String getPump_phone_number() {
            return pump_phone_number;
        }

        public void setPump_phone_number(String pump_phone_number) {
            this.pump_phone_number = pump_phone_number;
        }

        public String getPump_fax_number() {
            return pump_fax_number;
        }

        public void setPump_fax_number(String pump_fax_number) {
            this.pump_fax_number = pump_fax_number;
        }

        public String getPump_email() {
            return pump_email;
        }

        public void setPump_email(String pump_email) {
            this.pump_email = pump_email;
        }

        public String getPump_website() {
            return pump_website;
        }

        public void setPump_website(String pump_website) {
            this.pump_website = pump_website;
        }

        public String getPump_owner_name() {
            return pump_owner_name;
        }

        public void setPump_owner_name(String pump_owner_name) {
            this.pump_owner_name = pump_owner_name;
        }

        public String getPump_owner_mobile() {
            return pump_owner_mobile;
        }

        public void setPump_owner_mobile(String pump_owner_mobile) {
            this.pump_owner_mobile = pump_owner_mobile;
        }

        public String getPump_owner_phone() {
            return pump_owner_phone;
        }

        public void setPump_owner_phone(String pump_owner_phone) {
            this.pump_owner_phone = pump_owner_phone;
        }

        public String getPump_owner_email() {
            return pump_owner_email;
        }

        public void setPump_owner_email(String pump_owner_email) {
            this.pump_owner_email = pump_owner_email;
        }

        public String getPump_manager1_name() {
            return pump_manager1_name;
        }

        public void setPump_manager1_name(String pump_manager1_name) {
            this.pump_manager1_name = pump_manager1_name;
        }

        public String getPump_manager1_phone() {
            return pump_manager1_phone;
        }

        public void setPump_manager1_phone(String pump_manager1_phone) {
            this.pump_manager1_phone = pump_manager1_phone;
        }

        public String getPump_manager1_email() {
            return pump_manager1_email;
        }

        public void setPump_manager1_email(String pump_manager1_email) {
            this.pump_manager1_email = pump_manager1_email;
        }

        public String getPump_manager2_name() {
            return pump_manager2_name;
        }

        public void setPump_manager2_name(String pump_manager2_name) {
            this.pump_manager2_name = pump_manager2_name;
        }

        public String getPump_manager2_phone() {
            return pump_manager2_phone;
        }

        public void setPump_manager2_phone(String pump_manager2_phone) {
            this.pump_manager2_phone = pump_manager2_phone;
        }

        public String getPump_manager2_email() {
            return pump_manager2_email;
        }

        public void setPump_manager2_email(String pump_manager2_email) {
            this.pump_manager2_email = pump_manager2_email;
        }

        public String getPump_image_string() {
            return pump_image_string;
        }

        public void setPump_image_string(String pump_image_string) {
            this.pump_image_string = pump_image_string;
        }

        public String getOmc_code() {
            return omc_code;
        }

        public void setOmc_code(String omc_code) {
            this.omc_code = omc_code;
        }

        public int getCompany_operated() {
            return company_operated;
        }

        public void setCompany_operated(int company_operated) {
            this.company_operated = company_operated;
        }

        public int getPump_isActive() {
            return pump_isActive;
        }

        public void setPump_isActive(int pump_isActive) {
            this.pump_isActive = pump_isActive;
        }

        public int getPump_payment_terms() {
            return pump_payment_terms;
        }

        public void setPump_payment_terms(int pump_payment_terms) {
            this.pump_payment_terms = pump_payment_terms;
        }

        public String getPump_user_id() {
            return pump_user_id;
        }

        public void setPump_user_id(String pump_user_id) {
            this.pump_user_id = pump_user_id;
        }

        public String getPump_user_password() {
            return pump_user_password;
        }

        public void setPump_user_password(String pump_user_password) {
            this.pump_user_password = pump_user_password;
        }

        public String getUm_user_id() {
            return um_user_id;
        }

        public void setUm_user_id(String um_user_id) {
            this.um_user_id = um_user_id;
        }
    }

    public class Pump_List{

    }

}
