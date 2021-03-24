package com.example.trazacolor.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trazacolor.R
import com.example.trazacolor.databinding.FragmentSecondBinding
import com.example.trazacolor.local.Individuales
import com.example.trazacolor.viewmodel.ViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ViewModel by activityViewModels()
    lateinit var individuales: Individuales
    var idS: Int = 0
    var categoria: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            idS = requireArguments().getInt("id")
            categoria = requireArguments().getString("categoria", "")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (categoria) {
            "Individuales" -> categoria?.let {
                viewModel.selectedListIndividuales().observe(viewLifecycleOwner, {
                    it?.let {
                        binding.tvNameS.text = it[idS].nombre
                    }
                })
            }
            "Bolsas" -> categoria?.let {
                viewModel.selectedBolsas().observe(viewLifecycleOwner, {
                    it?.let {
                        binding.tvNameS.text = it[idS].nombre
                    }
                })
            }
            "DyeAndBee" -> categoria?.let {
                viewModel.selectedDAB().observe(viewLifecycleOwner, {
                    it?.let {
                        binding.tvNameS.text = it[idS].nombre
                    }
                })
            }
        }
    }
}