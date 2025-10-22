package com.android.baseapp.model

import androidx.annotation.Keep
import com.android.baseapp.core.BaseModel

@Keep
data class ActivityListModel(
    val text1:String,
    val text2:String?
): BaseModel()
