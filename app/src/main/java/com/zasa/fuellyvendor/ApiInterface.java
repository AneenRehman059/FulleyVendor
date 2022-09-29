package com.zasa.fuellyvendor;

import com.zasa.fuellyvendor.Request.App_Detail_Request;
import com.zasa.fuellyvendor.Request.Product_Wise_Request;
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

//    @FormUrlEncoded
//    @POST("Account/MemberLogin")
//    Call<Member_Login_Api> getMemberLogin(
//            @Field("Member_Mobile") String Member_Mobile,
//            @Field("Member_Password") String Member_Password
//    );
}
