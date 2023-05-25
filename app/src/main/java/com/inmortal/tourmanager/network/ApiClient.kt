package com.inmortal.tourmanager.network


import android.content.Context
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    val gson = GsonBuilder().setLenient().create()

    fun getRetrofitService(context: Context): ApiInterface {

        return Retrofit.Builder()
            .baseUrl("https://inmortaltech.com/Urplan/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiInterface::class.java)
    }





}