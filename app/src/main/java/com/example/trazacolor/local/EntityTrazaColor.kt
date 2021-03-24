package com.example.trazacolor.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_individuales")
data class EntityIndividuales(@PrimaryKey val id: Int, val nombre: String,
                              val material: String, val dimension: String, val precio: Int,
                              val categoria: String = "Individuales")

@Entity(tableName = "table_bolsas")
data class EntityBolsas(@PrimaryKey val id: Int, val nombre: String, val material: String,
                        val chica: String, val mediana: String, val grande: String,
                        val cantidad: String, val precio: Int,
                        val categoria: String = "Bolsas")

@Entity(tableName = "table_dab")
data class EntityDyeAndBee(@PrimaryKey val id: Int, val nombre: String, val chica: String,
                           val mediana: String, val grande: String, val extraGrande: String,
                           val cantidad: String, val material: String, val precio: Int,
                           val categoria: String = "DyeAndBee")
