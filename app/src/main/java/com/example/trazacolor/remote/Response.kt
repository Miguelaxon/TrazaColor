package com.example.trazacolor.remote

import com.example.trazacolor.local.Bolsas
import com.example.trazacolor.local.DyeAndBee
import com.example.trazacolor.local.Individuales
import com.example.trazacolor.local.ListaItem
import com.google.gson.annotations.SerializedName

data class ListaItem2(@SerializedName("list") val list: List<ListaItem>)

data class IndividualesResponse(@SerializedName("item") val individuales: List<Individuales>)

data class BolsasResponse(@SerializedName("item") val bolsas: List<Bolsas>)

data class DABResponse(@SerializedName("item") val dyeAndBee: List<DyeAndBee>)