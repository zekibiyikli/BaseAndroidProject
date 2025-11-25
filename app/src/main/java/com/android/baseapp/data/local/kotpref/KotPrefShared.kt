package com.android.baseapp.data.local.kotpref

import com.chibatching.kotpref.KotprefModel

object KotPrefShared: KotprefModel(){
    var testKotPref :String by stringPref("")
}