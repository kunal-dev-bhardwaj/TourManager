package com.inmortal.tourmanager.model

import com.google.gson.annotations.SerializedName

data class OtpModel (

    @SerializedName("success" ) var success : Boolean?        = null,
    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()

)

data class Data (

    @SerializedName("id"       ) var id    : String? = null,
    @SerializedName("group_id" ) var groupId : String? = null,
    @SerializedName("name"     ) var name    : String? = null,
    @SerializedName("mobile"   ) var mobile  : String? = null,
    @SerializedName("email"    ) var email   : String? = null,
    @SerializedName("hub"      ) var hub     : String? = null,
    @SerializedName("otp"      ) var otp     : String? = null,
    @SerializedName("status"   ) var status  : String? = null,
    @SerializedName("date"     ) var date    : String? = null

)
