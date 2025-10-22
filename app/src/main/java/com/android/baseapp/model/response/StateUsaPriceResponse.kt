package com.android.baseapp.model.response

import com.android.baseapp.core.BaseResponse
import com.android.baseapp.model.StateUsaPriceResultModel
import com.google.gson.annotations.SerializedName

data class StateUsaPriceResponse(
    @SerializedName("result")
    var result : StateUsaPriceResultModel?,
): BaseResponse()
