package com.android.baseapp.data.server

import com.android.baseapp.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("${Config.API_PREFIX}/?results=100")
    suspend fun getRandomUsers(): Response<UserResponse>
    @GET("${Config.API_PREFIX}/?results=100")
    suspend fun getRandomUsers2(): UserResponse


}