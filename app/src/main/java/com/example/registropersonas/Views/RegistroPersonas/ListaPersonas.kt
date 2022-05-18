package com.example.registropersonas.Views.RegistroPersonas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.registropersonas.R
import com.example.registropersonas.databinding.ListaPersonasFragmentBinding
import com.example.registropersonas.model.Persona
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListaPersonas : Fragment() {

    private val viewModel: RegistroPersonasViewModel by viewModels()
    private lateinit var binding: ListaPersonasFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaPersonasFragmentBinding.inflate(inflater, container, false)
        val adapter = PersonasAdapter(){
            OnPersonaClicked(it)
        }
        binding.personasReciclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.persona.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { lista -> adapter.submitList(lista) }
        }
        binding.agregarButton.setOnClickListener {
            OnPersonaClicked(null)
        }
        return binding.root
    }

    private fun OnPersonaClicked(persona: Persona?) {
        val action =  ListaPersonasDirections.actionToRegistroPersonasFragment(persona)
        findNavController().navigate(action)
    }


}