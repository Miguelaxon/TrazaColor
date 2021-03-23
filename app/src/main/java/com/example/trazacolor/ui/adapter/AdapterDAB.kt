package com.example.trazacolor.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.trazacolor.databinding.ItemDabBinding
import com.example.trazacolor.local.EntityDyeAndBee

class AdapterDAB: RecyclerView.Adapter<AdapterDAB.DABVH>() {
    private var listDAB = listOf<EntityDyeAndBee>()
    private val selectedDAB = MutableLiveData<EntityDyeAndBee>()

    fun selectedDAB(): LiveData<EntityDyeAndBee> = selectedDAB

    fun update(list: List<EntityDyeAndBee>) {
        listDAB = list
        notifyDataSetChanged()
    }

    inner class DABVH(private val binding: ItemDabBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
            fun bind(entityDyeAndBee: EntityDyeAndBee) {
                binding.tvDABTitle.text = entityDyeAndBee.nombre
                itemView.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            selectedDAB.value = listDAB[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DABVH {
        return DABVH(ItemDabBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DABVH, position: Int) {
        val list = listDAB[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int = listDAB.size
}