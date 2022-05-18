package com.example.registropersonas.Views.RegistroPersonas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.registropersonas.databinding.RowPersonasBinding
import com.example.registropersonas.model.Persona

class PersonasAdapter(private var onItemClicked: ((persona: Persona) -> Unit)) :
    ListAdapter<Persona, PersonasAdapter.PersonaViewHolder>(PersonaDiffCallBack()) {

    inner class PersonaViewHolder(private val binding: RowPersonasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Persona) {
            binding.personaId.text = item.personaId.toString()
            binding.txtvNombre.text = item.Nombre
            binding.txtvEmail.text = item.email
            binding.txtvSalario.text = item.salario.toString()

            binding.root.setOnClickListener {
               onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val binding = RowPersonasBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PersonaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }
}

class PersonaDiffCallBack : DiffUtil.ItemCallback<Persona>() {
    override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem.personaId == newItem.personaId
    }

    override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
        return oldItem == newItem
    }

}
