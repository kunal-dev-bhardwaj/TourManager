package com.inmortal.tourmanager.model

import com.google.gson.annotations.SerializedName

data class LogInModel (

    @SerializedName("success" ) var success : Boolean? = null,
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("otp"     ) var otp     : Int?     = null

)
