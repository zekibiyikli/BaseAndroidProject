package com.android.baseapp.model

import androidx.annotation.Keep

@Keep
data class UserLocationCoordinatesModel(
    var latitude: String,
    var longitude:String
)