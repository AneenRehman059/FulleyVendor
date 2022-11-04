package com.zasa.fuellyvendor;

import com.zasa.fuellyvendor.models.App_Detail_Request;
import com.zasa.fuellyvendor.Request.Product_Wise_Request;
import com.zasa.fuellyvendor.models.Member_Detail_Model;
import com.zasa.fuellyvendor.models.getFuelUp;
import com.zasa.fuellyvendor.models.getOmcListApi;
import com.zasa.fuellyvendor.models.GetQrData_Model;
/*import com.zasa.fuellyvendor.Response.Member_Login_Api;*/

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Common/App_Details")
    Call<App_Detail_Request> appDetails(
            @Field("App_Id") String app_id);

    @FormUrlEncoded
    @POST("Common/GetProducts")
    Call<Product_Wise_Request> getProductTypeWise(
            @Field("Pro_Code") String pro_code
    );

    @FormUrlEncoded
    @POST("Pump/PumpLogin")
    Call<Member_Detail_Model> getMember_Detail(
            @Field("Pump_User_Id") String member_mobile,
            @Field("Pump_User_Password") String member_password
    );

    @FormUrlEncoded
    @POST("OMC/GetOMCList")
    Call<getOmcListApi> getOmcDetail(
            @Field("Coperation") int coperation
    );

    @FormUrlEncoded
    @POST("QR/GetQRData")
    Call<GetQrData_Model> getQRData(
            @Field("Coperation") int coperation,
            @Field("QR_Id") String qr_id
    );

    @FormUrlEncoded
    @POST("QR/QRFuellup")
    Call<getFuelUp> getQrFuelup(
            String splitQr, @Field("QR_Id") String qr_id,
            @Field("Pump_Code") String pump_code,
            @Field("Actual_Fuel") double actual_fuel,
            @Field("Fuel_Up_Lat") String fuel_up_lat,
            @Field("Fuel_Up_Long") String fuel_up_long,
            @Field("Fuel_Up_Location") String fuel_up_location
    );

//    @FormUrlEncoded
//    @POST("Account/MemberLogin")
//    Call<Member_Login_Api> getMemberLogin(
//            @Field("Member_Mobile") String Member_Mobile,
//            @Field("Member_Password") String Member_Password
//    );
}
