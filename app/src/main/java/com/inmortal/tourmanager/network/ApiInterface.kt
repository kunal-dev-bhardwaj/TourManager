package com.inmortal.tourmanager.network


import com.inmortal.tourmanager.model.LogInModel
import com.inmortal.tourmanager.model.OtpModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("LoginTourManager")
    fun logIn(
      @Field("name") name:String,
      @Field("mobile") mobile:String,
      @Field("email") email: String

    ): Call<LogInModel>

    @FormUrlEncoded
    @POST("tourmanagerotpverified")
    fun otp(
        @Field("otp") otp:String

    ):Call<OtpModel>

}