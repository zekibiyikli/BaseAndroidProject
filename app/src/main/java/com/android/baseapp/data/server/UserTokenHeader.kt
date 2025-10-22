package com.android.baseapp.data.server

import okhttp3.Interceptor
import okhttp3.Response

class UserTokenHeader : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader(KEY_CONTENT_TYPE, HEADER_CONTENT_TYPE)
            .header("authorization", Config.HEADER_TOKEN) // Header ekle
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        const val HEADER_CONTENT_TYPE = "application/json"
        const val KEY_CONTENT_TYPE = "content-type"
    }
}
