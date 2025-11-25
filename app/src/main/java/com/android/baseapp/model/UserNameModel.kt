package com.android.baseapp.model

import androidx.annotation.Keep

@Keep
data class UserNameModel(
    var title: String,
    var first: String,
    var last: String
)