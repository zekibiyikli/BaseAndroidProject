package com.android.baseapp.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.android.baseapp.core.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class StateModel(
    @SerializedName("name")
    var name :String?,
    @SerializedName("regular")
    var regular :String?,
    @SerializedName("midGrade")
    var midGrade :String?,
    @SerializedName("premium")
    var premium :String?,
    @SerializedName("diesel")
    var diesel :String?
): BaseModel(), Parcelable
