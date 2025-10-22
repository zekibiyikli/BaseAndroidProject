package com.android.baseapp.data.server

import com.android.baseapp.model.request.FromCoordinatesRequest
import com.android.baseapp.model.response.FromCoordinatesResponse
import com.android.baseapp.model.response.StateUsaPriceResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("${Config.API_PREFIX}/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara")
    suspend fun stateUsaPrice(@Query("ilce") ilce: String?, @Query("il") il: String?): Response<StateUsaPriceResponse>

    //Örnek olması için yapıldı
    @GET("${Config.API_PREFIX}/fromCoordinates")
    suspend fun fromCoordinates(@Body request: FromCoordinatesRequest): Response<FromCoordinatesResponse>

}