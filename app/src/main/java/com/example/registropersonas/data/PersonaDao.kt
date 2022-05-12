package com.example.registropersonas.data

import androidx.room.*
import com.example.registropersonas.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)

    @Delete
    suspend fun Eliminar(persona: Persona)

    @Query("SELECT * FROM Personas ORDER BY personaId")
    fun GetLista(): Flow<List<Persona>>
}