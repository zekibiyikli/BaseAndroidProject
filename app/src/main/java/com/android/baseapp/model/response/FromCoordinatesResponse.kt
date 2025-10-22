package com.android.baseapp.model.response

import com.android.baseapp.core.BaseResponse
import com.android.baseapp.model.StateModel
import com.android.baseapp.model.StateUsaPriceResultModel
import com.google.gson.annotations.SerializedName

data class FromCoordinatesResponse(
    @SerializedName("result")
    var result :ArrayList<StateModel>?
): BaseResponse()
