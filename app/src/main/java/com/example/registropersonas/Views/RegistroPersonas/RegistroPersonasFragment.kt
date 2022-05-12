package com.example.registropersonas.Views.RegistroPersonas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registropersonas.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistroPersonasFragment : Fragment() {

    companion object {
        fun newInstance() = RegistroPersonasFragment()
    }

    private lateinit var viewModel: RegistroPersonasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registro_personas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistroPersonasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}