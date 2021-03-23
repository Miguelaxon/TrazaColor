package com.example.trazacolor.remote

import com.example.trazacolor.local.EntityBolsas
import com.example.trazacolor.local.EntityData
import com.example.trazacolor.local.EntityIndividuales
import com.example.trazacolor.local.ListaItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiClient {
    @GET("trazacolor/individuales")
    suspend fun getFecthIndividuales(): Response<IndividualesResponse>

    @GET("trazacolor/bolsas")
    suspend fun getFetchBolsas(): Response<BolsasResponse>

    @GET("trazacolor/dab")
    suspend fun getFetchDAB(): Response<DABResponse>
}