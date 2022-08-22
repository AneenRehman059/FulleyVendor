package com.zasa.fuellyvendor.Retrofit;


import com.zasa.fuellyvendor.SliderApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {


    //////////////////////Get APIs////////////////////////


    //////Tech Member list api//////
    //@GET("Tech/TechMembers")
    //Call<TechMembersListApi> mTechMembersListApi();






    //////////////////////Post APIs////////////////////////

    //////Sliders api//////
    @FormUrlEncoded
    @POST("Common/Sliders")
    Call<SliderApi> mSliderApi(
            @Field("APP_ID") String appid
    );

}
