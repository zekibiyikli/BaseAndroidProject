package com.android.baseapp.model

import androidx.annotation.Keep

@Keep
data class ErrorModel(
    val code: String,
    val message:String?
)
