package com.example.registropersonas.Views.RegistroPersonas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registropersonas.data.PersonaDao
import com.example.registropersonas.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroPersonasViewModel @Inject constructor(
    private val personasDao : PersonaDao
): ViewModel() {
    fun guardar(persona : Persona){
        viewModelScope.launch {
            personasDao.Insertar(persona)
        }
    }
}