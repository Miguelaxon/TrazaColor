package com.example.trazacolor.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityIndividuales::class, EntityBolsas::class, EntityDyeAndBee::class],
    version = 1)
abstract class BaseDatos: RoomDatabase() {
    abstract fun getIDAO(): IDao
    companion object {
        @Volatile
        private var INSTANCE: BaseDatos? = null
        fun getDataBase(context: Context): BaseDatos {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                        BaseDatos::class.java, "basedatos").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}