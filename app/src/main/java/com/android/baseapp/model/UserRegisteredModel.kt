package com.android.baseapp.model

import androidx.annotation.Keep

@Keep
data class UserRegisteredModel(
    var date: String,
    var age: Int
)