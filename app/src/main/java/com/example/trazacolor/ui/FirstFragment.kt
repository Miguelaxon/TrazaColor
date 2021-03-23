package com.example.trazacolor.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trazacolor.databinding.FragmentFirstBinding
import com.example.trazacolor.ui.adapter.AdapterBolsas
import com.example.trazacolor.ui.adapter.AdapterIndividuales
import com.example.trazacolor.ui.adapter.AdapterDAB
import com.example.trazacolor.viewmodel.ViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterIndividuales()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)

        viewModel.selectedListIndividuales().observe(viewLifecycleOwner, {
            it?.let {
                adapter.update(it)
            }
        })

        val adapter2 = AdapterBolsas()
        binding.rv2.adapter = adapter2
        binding.rv2.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)

        viewModel.selectedBolsas().observe(viewLifecycleOwner, {
            it?.let {
                adapter2.update(it)
            }
        })

        val adapter3 = AdapterDAB()
        binding.rv3.adapter = adapter3
        binding.rv3.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)

        viewModel.selectedDAB().observe(viewLifecycleOwner, {
            it?.let {
                adapter3.update(it)
            }
        })
    }
}