package com.android.baseapp.core

import com.google.gson.annotations.SerializedName


open class BaseResponse(
    @SerializedName("success")
    val success: Boolean?=false
)