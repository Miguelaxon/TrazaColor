package com.example.trazacolor.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.trazacolor.databinding.ItemIndividualesBinding
import com.example.trazacolor.local.EntityIndividuales

class AdapterIndividuales: RecyclerView.Adapter<AdapterIndividuales.ItemVH>() {
    private var listIndividuales = listOf<EntityIndividuales>()
    private val selectedIndividuales = MutableLiveData<EntityIndividuales>()

    fun selectedIndividuales(): LiveData<EntityIndividuales> = selectedIndividuales

    fun update(list: List<EntityIndividuales>) {
        listIndividuales = list
        notifyDataSetChanged()
    }

    inner class ItemVH(private val binding: ItemIndividualesBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            selectedIndividuales.value = listIndividuales[adapterPosition]
        }
        fun bind(entityIndividuales: EntityIndividuales) {
            binding.tvItemTitle.text = entityIndividuales.nombre
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        return ItemVH(ItemIndividualesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val lista = listIndividuales[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listIndividuales.size
}