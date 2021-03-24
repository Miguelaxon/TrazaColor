package com.example.trazacolor.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.trazacolor.local.*
import com.example.trazacolor.remote.ApiClient

class Repository(private val iDao: IDao) {
    val listIndividuales: LiveData<List<EntityIndividuales>> = iDao.getAllIndividuales()
    val listBolsas: LiveData<List<EntityBolsas>> = iDao.getAllBolsas()
    val listDAB: LiveData<List<EntityDyeAndBee>> = iDao.getAllDAB()

    fun converterIndividuales(list: List<Individuales>): List<EntityIndividuales> {
        val lista: MutableList<EntityIndividuales> = mutableListOf()
        list.map {
            lista.add(EntityIndividuales(id = it.id, nombre = it.nombre, material =  it.material,
                    dimension =  it.dimension, precio =  it.precio))
        }
        return lista
    }

    suspend fun getFetchCorountinesIndividuales() {
        try {
            val response = ApiClient.getApiClient().getFecthIndividuales()
            when(response.isSuccessful) {
                true -> response.body()?.let {
                    iDao.insertAllIndividuales(converterIndividuales(it.individuales))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        } catch (t: Throwable){
            Log.d("Error Coroutine", t.message.toString())
        }
    }

    fun converterBolsas(list: List<Bolsas>): List<EntityBolsas> {
        val lista: MutableList<EntityBolsas> = mutableListOf()
        list.map {
            lista.add(EntityBolsas(id = it.id, nombre = it.nombre, material = it.material, chica = it.chica,
                    mediana = it.mediana, grande = it.grande, precio = it.precio,
                    cantidad = it.cantidad))
        }
        return lista
    }

    suspend fun getFetchCorountinesBolsas() {
        try {
            val response = ApiClient.getApiClient().getFetchBolsas()
            when(response.isSuccessful) {
                true -> response.body()?.let {
                    iDao.insertAllBolsas(converterBolsas(it.bolsas))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        } catch (t: Throwable){
            Log.d("Error Coroutine", t.message.toString())
        }
    }

    fun converterDAB(list: List<DyeAndBee>): List<EntityDyeAndBee> {
        val lista: MutableList<EntityDyeAndBee> = mutableListOf()
        list.map {
            lista.add(EntityDyeAndBee(id = it.id, nombre = it.nombre, chica = it.chica, mediana = it.mediana,
                    grande = it.grande, cantidad = it.cantidad, material = it.material,
                    precio = it.precio, extraGrande = it.extraGrande))
        }
        return lista
    }

    suspend fun getFetchCorountinesDAB() {
        try {
            val response = ApiClient.getApiClient().getFetchDAB()
            when(response.isSuccessful) {
                true -> response.body()?.let {
                    iDao.insertAllDAB(converterDAB(it.dyeAndBee))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        } catch (t: Throwable){
            Log.d("Error Coroutine", t.message.toString())
        }
    }

    fun getIndividuales(): LiveData<List<EntityIndividuales>> = iDao.getAllIndividuales()

    fun getBolsas(): LiveData<List<EntityBolsas>> = iDao.getAllBolsas()

    fun getDAB(): LiveData<List<EntityDyeAndBee>> = iDao.getAllDAB()
}