package com.example.trazacolor.local

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AllData (@SerializedName("individuales")
                       val individuales: List<Individuales>,
                       @SerializedName("bolsas multiproposito")
                       val bolsasMultiproposito: List<Bolsas>,
                       @SerializedName("dye and bee")
                       val dyeAndBee: List<DyeAndBee>)

data class ListaItem(@SerializedName("name") val name: String,
                    @SerializedName("urlImage") val image: String)

data class Individuales(@SerializedName("nombre") val nombre: String,
                           @SerializedName("material") val material: String,
                           @SerializedName("dimension") val dimension: String,
                           @SerializedName("precio") val precio: Int)

data class Bolsas(@SerializedName("nombre") val nombre: String,
                  @SerializedName("material") val material: String,
                  @SerializedName("chica") val chica: String,
                  @SerializedName("mediana") val mediana: String,
                  @SerializedName("grande") val grande: String,
                  @SerializedName("cantidad") val cantidad: String,
                  @SerializedName("precio") val precio: Int)

data class DyeAndBee(@SerializedName("nombre") val nombre: String,
                     @SerializedName("cantidad") val cantidad: String,
                     @SerializedName("chica") val chica: String,
                     @SerializedName("mediana") val mediana: String,
                     @SerializedName("grande") val grande: String,
                     @SerializedName("xl") val extraGrande: String,
                     @SerializedName("material") val material: String,
                     @SerializedName("precio") val precio: Int)
