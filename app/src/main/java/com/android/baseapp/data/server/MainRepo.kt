package com.android.baseapp.data.server

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.model.request.FromCoordinatesRequest
import com.android.baseapp.model.response.FromCoordinatesResponse
import com.android.baseapp.model.response.StateUsaPriceResponse
import retrofit2.Response

class MainRepo(private val apiService: ApiService) : BaseRepository() {
    suspend fun stateUsaPrice(ilce: String,il:String): Response<StateUsaPriceResponse> = apiService.stateUsaPrice(ilce,il)
    suspend fun fromCoordinates(request: FromCoordinatesRequest): Response<FromCoordinatesResponse> = apiService.fromCoordinates(request)
}