package com.example.registropersonas.di

import android.content.Context
import androidx.room.Room
import com.example.registropersonas.data.PersonaDao
import com.example.registropersonas.data.Personasdb
import com.example.registropersonas.model.Persona
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun ProviePersonasDb(@ApplicationContext appContext: Context): Personasdb {
        return Room.databaseBuilder(
            appContext,
            Personasdb::class.java,
            "Personas.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonasDao(personasDb: Personasdb): PersonaDao{
        return personasDb.personaDao
    }
}