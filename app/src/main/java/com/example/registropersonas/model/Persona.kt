package com.example.registropersonas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName ="Personas")
@Parcelize
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val Nombre: String,
    val email: String,
    val ocupacioId: Int,
    val salario: Float
):Parcelable
