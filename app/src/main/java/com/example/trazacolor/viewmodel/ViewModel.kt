package com.example.trazacolor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.trazacolor.local.*
import com.example.trazacolor.model.Repository
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository
    val listaIndividuales: LiveData<List<EntityIndividuales>>
    val listaBolsas: LiveData<List<EntityBolsas>>
    val listaDAB: LiveData<List<EntityDyeAndBee>>

    fun selectedListIndividuales(): LiveData<List<EntityIndividuales>> = repository.getIndividuales()

    fun selectedBolsas(): LiveData<List<EntityBolsas>> = repository.getBolsas()

    fun selectedDAB(): LiveData<List<EntityDyeAndBee>> = repository.getDAB()

    init {
        val baseDatos = BaseDatos.getDataBase(application).getIDAO()
        repository = Repository(baseDatos)
        viewModelScope.launch {
            repository.getFetchCorountinesIndividuales()
        }
        listaIndividuales = repository.listIndividuales
    }

    init {
        viewModelScope.launch {
            repository.getFetchCorountinesBolsas()
        }
        listaBolsas = repository.listBolsas
    }

    init {
        viewModelScope.launch {
            repository.getFetchCorountinesDAB()
        }
        listaDAB = repository.listDAB
    }
}