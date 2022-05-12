package com.example.registropersonas.Views.RegistroPersonas


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.registropersonas.R
import com.example.registropersonas.Utilities.getFloat
import com.example.registropersonas.Utilities.getInt
import com.example.registropersonas.databinding.RegistroPersonasFragmentBinding
import com.example.registropersonas.model.Persona
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class RegistroPersonasFragment : Fragment(), AdapterView.OnItemSelectedListener {


    private val viewModel: RegistroPersonasViewModel by viewModels()
    private lateinit var binding: RegistroPersonasFragmentBinding
    private var spinner: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistroPersonasFragmentBinding.inflate(inflater, container, false)

        binding.btnGuardae.setOnClickListener {


            viewModel.guardar(LLenar())
            val snackbar = Snackbar.make(binding.root, "Persona guardada", Snackbar.LENGTH_LONG).show()
        }
        return binding.root
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        spinner = position
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun LLenar(): Persona {
        binding.Spinnerocupaciones.onItemSelectedListener = this
        val persona = Persona(
            binding.txtPersonaId.text.getInt(),
            binding.txtNombre.text.toString(),
            binding.txtEmail.text.toString(),
            spinner,
            binding.txtSalario.text.getFloat()
        )
        return persona
    }
}


