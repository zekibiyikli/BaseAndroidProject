package com.android.baseapp.data.local

import com.chibatching.kotpref.KotprefModel

object KotPrefShared: KotprefModel(){
    var testKotPref :String by stringPref("")
}