package com.example.registropersonas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registropersonas.model.Persona

@Database(
    entities = [Persona::class],
    version = 1
)
abstract class Personasdb: RoomDatabase() {
    abstract val personaDao: PersonaDao
}