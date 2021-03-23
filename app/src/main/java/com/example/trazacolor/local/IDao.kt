package com.example.trazacolor.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trazacolor.remote.BolsasResponse

@Dao
interface IDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIndividuales(item: List<EntityIndividuales>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBolsas(item: List<EntityBolsas>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDAB(item: List<EntityDyeAndBee>)

    @Query("SELECT * FROM table_individuales")
    fun getAllIndividuales(): LiveData<List<EntityIndividuales>>

    @Query("SELECT * FROM table_bolsas")
    fun getAllBolsas(): LiveData<List<EntityBolsas>>

    @Query("SELECT * FROM table_dab")
    fun getAllDAB(): LiveData<List<EntityDyeAndBee>>
}