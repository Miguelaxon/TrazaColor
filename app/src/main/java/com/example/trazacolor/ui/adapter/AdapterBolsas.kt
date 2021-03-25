package com.example.trazacolor.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trazacolor.R
import com.example.trazacolor.databinding.ItemBolsasBinding
import com.example.trazacolor.local.EntityBolsas

class AdapterBolsas: RecyclerView.Adapter<AdapterBolsas.BolsasVH>() {
    private var listBolsas = listOf<EntityBolsas>()
    private val selectedBolsas = MutableLiveData<EntityBolsas>()

    fun selectedBolsas(): LiveData<EntityBolsas> = selectedBolsas

    fun update(list: List<EntityBolsas>) {
        listBolsas = list
        notifyDataSetChanged()
    }

    inner class BolsasVH(private val binding: ItemBolsasBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            selectedBolsas.value = listBolsas[adapterPosition]
        }
        fun bind(entityBolsas: EntityBolsas) {
            binding.tvBolsasTitle.text = entityBolsas.nombre
            Glide.with(binding.ivBolsas).load(entityBolsas.urlImage)
                    .placeholder(R.drawable.ic_pregunta).into(binding.ivBolsas)
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BolsasVH {
        return BolsasVH(ItemBolsasBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BolsasVH, position: Int) {
        val lista = listBolsas[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listBolsas.size
}