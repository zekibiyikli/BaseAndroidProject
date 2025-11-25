package com.android.baseapp.model.response

import com.android.baseapp.core.BaseResponse
import com.android.baseapp.model.InfoModel
import com.android.baseapp.model.UserModel

data class UserResponse(
    var results : ArrayList<UserModel>?,
    var info: InfoModel?
): BaseResponse()
