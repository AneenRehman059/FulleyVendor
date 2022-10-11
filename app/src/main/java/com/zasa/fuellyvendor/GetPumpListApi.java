package com.zasa.fuellyvendor;

import androidx.annotation.Keep;

import java.util.ArrayList;


    @Keep
    public class GetPumpListApi {
        private String id;
        private int Status;
        private String Message;
        private String Pump_Details = null;
        ArrayList<PumpListModel> Pump_List = new ArrayList<>();

        public GetPumpListApi(String id, int status, String message, String pump_Details, ArrayList<PumpListModel> pump_List) {
            this.id = id;
            Status = status;
            Message = message;
            Pump_Details = pump_Details;
            Pump_List = pump_List;
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

        public String getPump_Details() {
            return Pump_Details;
        }

        public void setPump_Details(String pump_Details) {
            Pump_Details = pump_Details;
        }

        public ArrayList<PumpListModel> getPump_List() {
            return Pump_List;
        }

        public void setPump_List(ArrayList<PumpListModel> pump_List) {
            Pump_List = pump_List;
        }


        public class PumpListModel{
            private String id;
            private int Coperation;
            private String Pump_Code;
            private String strPump_Code;
            private String Pump_TPIN;
            private String Pump_Title;
            private String Pump_Address;
            private String Pump_NTN;
            private String Pump_STN;
            private String Pump_Bank_Name;
            private String Pump_Account_Number;
            private String Pump_Account_Title;
            private String Pump_Phone_Number;
            private String Pump_Fax_Number;
            private String Pump_Email;
            private String Pump_Website;
            private String Pump_Owner_Name;
            private String Pump_Owner_Mobile;
            private String Pump_Owner_Phone;
            private String Pump_Owner_Email;
            private String Pump_Manager1_Name;
            private String Pump_Manager1_Phone;
            private String Pump_Manager1_Email;
            private String Pump_Manager2_Name;
            private String Pump_Manager2_Phone;
            private String Pump_Manager2_Email;
            private String Pump_Image_String;
            private String OMC_Code;
            private String Company_Operated;
            private String Pump_IsActive;
            private String Pump_Payment_Terms;
            private String Pump_User_Id;
            private String Pump_User_Password=null;
            private String UM_User_Id=null;

            public PumpListModel(String id, int coperation, String pump_Code, String strPump_Code, String pump_TPIN, String pump_Title, String pump_Address, String pump_NTN, String pump_STN, String pump_Bank_Name, String pump_Account_Number, String pump_Account_Title, String pump_Phone_Number, String pump_Fax_Number, String pump_Email, String pump_Website, String pump_Owner_Name, String pump_Owner_Mobile, String pump_Owner_Phone, String pump_Owner_Email, String pump_Manager1_Name, String pump_Manager1_Phone, String pump_Manager1_Email, String pump_Manager2_Name, String pump_Manager2_Phone, String pump_Manager2_Email, String pump_Image_String, String OMC_Code, String company_Operated, String pump_IsActive, String pump_Payment_Terms, String pump_User_Id, String pump_User_Password, String UM_User_Id) {
                this.id = id;
                Coperation = coperation;
                Pump_Code = pump_Code;
                this.strPump_Code = strPump_Code;
                Pump_TPIN = pump_TPIN;
                Pump_Title = pump_Title;
                Pump_Address = pump_Address;
                Pump_NTN = pump_NTN;
                Pump_STN = pump_STN;
                Pump_Bank_Name = pump_Bank_Name;
                Pump_Account_Number = pump_Account_Number;
                Pump_Account_Title = pump_Account_Title;
                Pump_Phone_Number = pump_Phone_Number;
                Pump_Fax_Number = pump_Fax_Number;
                Pump_Email = pump_Email;
                Pump_Website = pump_Website;
                Pump_Owner_Name = pump_Owner_Name;
                Pump_Owner_Mobile = pump_Owner_Mobile;
                Pump_Owner_Phone = pump_Owner_Phone;
                Pump_Owner_Email = pump_Owner_Email;
                Pump_Manager1_Name = pump_Manager1_Name;
                Pump_Manager1_Phone = pump_Manager1_Phone;
                Pump_Manager1_Email = pump_Manager1_Email;
                Pump_Manager2_Name = pump_Manager2_Name;
                Pump_Manager2_Phone = pump_Manager2_Phone;
                Pump_Manager2_Email = pump_Manager2_Email;
                Pump_Image_String = pump_Image_String;
                this.OMC_Code = OMC_Code;
                Company_Operated = company_Operated;
                Pump_IsActive = pump_IsActive;
                Pump_Payment_Terms = pump_Payment_Terms;
                Pump_User_Id = pump_User_Id;
                Pump_User_Password = pump_User_Password;
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

            public String getPump_Code() {
                return Pump_Code;
            }

            public void setPump_Code(String pump_Code) {
                Pump_Code = pump_Code;
            }

            public String getStrPump_Code() {
                return strPump_Code;
            }

            public void setStrPump_Code(String strPump_Code) {
                this.strPump_Code = strPump_Code;
            }

            public String getPump_TPIN() {
                return Pump_TPIN;
            }

            public void setPump_TPIN(String pump_TPIN) {
                Pump_TPIN = pump_TPIN;
            }

            public String getPump_Title() {
                return Pump_Title;
            }

            public void setPump_Title(String pump_Title) {
                Pump_Title = pump_Title;
            }

            public String getPump_Address() {
                return Pump_Address;
            }

            public void setPump_Address(String pump_Address) {
                Pump_Address = pump_Address;
            }

            public String getPump_NTN() {
                return Pump_NTN;
            }

            public void setPump_NTN(String pump_NTN) {
                Pump_NTN = pump_NTN;
            }

            public String getPump_STN() {
                return Pump_STN;
            }

            public void setPump_STN(String pump_STN) {
                Pump_STN = pump_STN;
            }

            public String getPump_Bank_Name() {
                return Pump_Bank_Name;
            }

            public void setPump_Bank_Name(String pump_Bank_Name) {
                Pump_Bank_Name = pump_Bank_Name;
            }

            public String getPump_Account_Number() {
                return Pump_Account_Number;
            }

            public void setPump_Account_Number(String pump_Account_Number) {
                Pump_Account_Number = pump_Account_Number;
            }

            public String getPump_Account_Title() {
                return Pump_Account_Title;
            }

            public void setPump_Account_Title(String pump_Account_Title) {
                Pump_Account_Title = pump_Account_Title;
            }

            public String getPump_Phone_Number() {
                return Pump_Phone_Number;
            }

            public void setPump_Phone_Number(String pump_Phone_Number) {
                Pump_Phone_Number = pump_Phone_Number;
            }

            public String getPump_Fax_Number() {
                return Pump_Fax_Number;
            }

            public void setPump_Fax_Number(String pump_Fax_Number) {
                Pump_Fax_Number = pump_Fax_Number;
            }

            public String getPump_Email() {
                return Pump_Email;
            }

            public void setPump_Email(String pump_Email) {
                Pump_Email = pump_Email;
            }

            public String getPump_Website() {
                return Pump_Website;
            }

            public void setPump_Website(String pump_Website) {
                Pump_Website = pump_Website;
            }

            public String getPump_Owner_Name() {
                return Pump_Owner_Name;
            }

            public void setPump_Owner_Name(String pump_Owner_Name) {
                Pump_Owner_Name = pump_Owner_Name;
            }

            public String getPump_Owner_Mobile() {
                return Pump_Owner_Mobile;
            }

            public void setPump_Owner_Mobile(String pump_Owner_Mobile) {
                Pump_Owner_Mobile = pump_Owner_Mobile;
            }

            public String getPump_Owner_Phone() {
                return Pump_Owner_Phone;
            }

            public void setPump_Owner_Phone(String pump_Owner_Phone) {
                Pump_Owner_Phone = pump_Owner_Phone;
            }

            public String getPump_Owner_Email() {
                return Pump_Owner_Email;
            }

            public void setPump_Owner_Email(String pump_Owner_Email) {
                Pump_Owner_Email = pump_Owner_Email;
            }

            public String getPump_Manager1_Name() {
                return Pump_Manager1_Name;
            }

            public void setPump_Manager1_Name(String pump_Manager1_Name) {
                Pump_Manager1_Name = pump_Manager1_Name;
            }

            public String getPump_Manager1_Phone() {
                return Pump_Manager1_Phone;
            }

            public void setPump_Manager1_Phone(String pump_Manager1_Phone) {
                Pump_Manager1_Phone = pump_Manager1_Phone;
            }

            public String getPump_Manager1_Email() {
                return Pump_Manager1_Email;
            }

            public void setPump_Manager1_Email(String pump_Manager1_Email) {
                Pump_Manager1_Email = pump_Manager1_Email;
            }

            public String getPump_Manager2_Name() {
                return Pump_Manager2_Name;
            }

            public void setPump_Manager2_Name(String pump_Manager2_Name) {
                Pump_Manager2_Name = pump_Manager2_Name;
            }

            public String getPump_Manager2_Phone() {
                return Pump_Manager2_Phone;
            }

            public void setPump_Manager2_Phone(String pump_Manager2_Phone) {
                Pump_Manager2_Phone = pump_Manager2_Phone;
            }

            public String getPump_Manager2_Email() {
                return Pump_Manager2_Email;
            }

            public void setPump_Manager2_Email(String pump_Manager2_Email) {
                Pump_Manager2_Email = pump_Manager2_Email;
            }

            public String getPump_Image_String() {
                return Pump_Image_String;
            }

            public void setPump_Image_String(String pump_Image_String) {
                Pump_Image_String = pump_Image_String;
            }

            public String getOMC_Code() {
                return OMC_Code;
            }

            public void setOMC_Code(String OMC_Code) {
                this.OMC_Code = OMC_Code;
            }

            public String getCompany_Operated() {
                return Company_Operated;
            }

            public void setCompany_Operated(String company_Operated) {
                Company_Operated = company_Operated;
            }

            public String getPump_IsActive() {
                return Pump_IsActive;
            }

            public void setPump_IsActive(String pump_IsActive) {
                Pump_IsActive = pump_IsActive;
            }

            public String getPump_Payment_Terms() {
                return Pump_Payment_Terms;
            }

            public void setPump_Payment_Terms(String pump_Payment_Terms) {
                Pump_Payment_Terms = pump_Payment_Terms;
            }

            public String getPump_User_Id() {
                return Pump_User_Id;
            }

            public void setPump_User_Id(String pump_User_Id) {
                Pump_User_Id = pump_User_Id;
            }

            public String getPump_User_Password() {
                return Pump_User_Password;
            }

            public void setPump_User_Password(String pump_User_Password) {
                Pump_User_Password = pump_User_Password;
            }

            public String getUM_User_Id() {
                return UM_User_Id;
            }

            public void setUM_User_Id(String UM_User_Id) {
                this.UM_User_Id = UM_User_Id;
            }
        }
    }

