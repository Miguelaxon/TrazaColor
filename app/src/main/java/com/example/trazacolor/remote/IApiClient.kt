package com.example.trazacolor.remote

import retrofit2.Response
import retrofit2.http.GET

interface IApiClient {
    @GET("trazacolor/individuales")
    suspend fun getFecthIndividuales(): Response<IndividualesResponse>

    @GET("trazacolor/bolsas")
    suspend fun getFetchBolsas(): Response<BolsasResponse>

    @GET("trazacolor/dab")
    suspend fun getFetchDAB(): Response<DABResponse>
}