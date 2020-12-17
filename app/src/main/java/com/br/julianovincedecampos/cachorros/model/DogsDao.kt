package com.br.julianovincedecampos.cachorros.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DogsDao {

    @Insert
    suspend fun insertAll(vararg dogs: DogBreed): List<Long>

    @Query("SELECT * FROM dogbreed")
    suspend fun getAllDogs(): List<DogBreed>

    @Query("DELETE FROM dogbreed")
    suspend fun deleteAllDogs()

}