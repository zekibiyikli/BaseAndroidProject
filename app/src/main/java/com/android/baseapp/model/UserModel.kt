package com.android.baseapp.model

import androidx.annotation.Keep
import com.android.baseapp.core.BaseModel

@Keep
data class UserModel(
    var gender: String,
    var name:UserNameModel,
    var location:UserLocationModel,
    var email:String,
    var login: UserLoginModel,
    var dob: UserDobModel,
    var registered: UserRegisteredModel,
    var phone: String,
    var cell: String,
    var id: UserIdModel,
    var picture: UserPictureModel,
    var nat:String,
): BaseModel()