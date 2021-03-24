package com.example.trazacolor.local

import com.google.gson.annotations.SerializedName

data class Individuales(@SerializedName("id") val id: Int,
                        @SerializedName("nombre") val nombre: String,
                        @SerializedName("material") val material: String,
                        @SerializedName("dimension") val dimension: String,
                        @SerializedName("precio") val precio: Int,
                        val categoria: String)

data class Bolsas(@SerializedName("id") val id: Int,
                  @SerializedName("nombre") val nombre: String,
                  @SerializedName("material") val material: String,
                  @SerializedName("chica") val chica: String,
                  @SerializedName("mediana") val mediana: String,
                  @SerializedName("grande") val grande: String,
                  @SerializedName("cantidad") val cantidad: String,
                  @SerializedName("precio") val precio: Int,
                  val categoria: String)

data class DyeAndBee(@SerializedName("id") val id: Int,
                     @SerializedName("nombre") val nombre: String,
                     @SerializedName("cantidad") val cantidad: String,
                     @SerializedName("chica") val chica: String,
                     @SerializedName("mediana") val mediana: String,
                     @SerializedName("grande") val grande: String,
                     @SerializedName("xl") val extraGrande: String,
                     @SerializedName("material") val material: String,
                     @SerializedName("precio") val precio: Int,
                     val categoria: String)
