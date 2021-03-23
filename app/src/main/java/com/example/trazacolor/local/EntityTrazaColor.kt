package com.example.trazacolor.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_master")
data class EntityData (@PrimaryKey val id: Int = 1,
                       @SerializedName("individuales")
                       val individuales: List<Individuales>,
                       @SerializedName("bolsas multiproposito")
                       val bolsasMultiproposito: List<Bolsas>,
                       @SerializedName("dye and bee")
                       val dyeAndBee: List<DyeAndBee>)

@Entity(tableName = "table_lista")
data class EntityLista(@PrimaryKey val name: String, val image: String)

@Entity(tableName = "table_individuales")
data class EntityIndividuales(@PrimaryKey val nombre: String, val material: String,
                              val dimension: String, val precio: Int)

@Entity(tableName = "table_bolsas")
data class EntityBolsas(@SerializedName("nombre") @PrimaryKey val nombre: String,
                        @SerializedName("material") val material: String,
                        @SerializedName("chica") val chica: String,
                        @SerializedName("mediana") val mediana: String,
                        @SerializedName("grande") val grande: String,
                        @SerializedName("cantidad") val cantidad: String,
                        @SerializedName("precio") val precio: Int)

@Entity(tableName = "table_dab")
data class EntityDyeAndBee(@SerializedName("nombre") @PrimaryKey val nombre: String,
                           @SerializedName("chica") val chica: String,
                           @SerializedName("mediana") val mediana: String,
                           @SerializedName("grande") val grande: String,
                           @SerializedName("xl") val extraGrande: String,
                           @SerializedName("cantidad") val cantidad: String,
                           @SerializedName("material") val material: String,
                           @SerializedName("precio") val precio: Int)
