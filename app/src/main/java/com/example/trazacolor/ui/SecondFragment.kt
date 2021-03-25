package com.example.trazacolor.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.trazacolor.R
import com.example.trazacolor.databinding.FragmentSecondBinding
import com.example.trazacolor.local.Individuales
import com.example.trazacolor.viewmodel.ViewModel
import java.text.DecimalFormat

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ViewModel by activityViewModels()
    lateinit var individuales: Individuales
    var idS: Int = 0
    var categoria: String = ""
    var cant:Int = 0

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
        val formatter = DecimalFormat("$#,###")
        when (categoria) {
            "Individuales" -> categoria?.let {
                viewModel.selectedListIndividuales().observe(viewLifecycleOwner, {
                    it?.let {
                        Glide.with(binding.ivItemS).load(it[idS].urlImage).circleCrop()
                                .placeholder(R.drawable.ic_pregunta).into(binding.ivItemS)
                        binding.tvNameS.text = it[idS].nombre.toUpperCase()
                        binding.tvMaterialS.text = getString(R.string.material, it[idS].material)
                        binding.tvDimensionChic.text =
                                getString(R.string.dimensionChica,it[idS].dimension)
                        binding.tvPrecioS.text =
                                getString(R.string.precio, formatter.format(it[idS].precio).toString())
                        binding.tvDimensionMed.isVisible = false
                        binding.tvDimensionGran.isVisible = false
                        binding.tvDimensionXL.isVisible = false
                        binding.tvCantidadS.isVisible = false
                        botones()
                    }
                })
            }
            "Bolsas" -> categoria?.let {
                viewModel.selectedBolsas().observe(viewLifecycleOwner, {
                    it?.let {
                        Glide.with(binding.ivItemS).load(it[idS].urlImage).circleCrop()
                                .placeholder(R.drawable.ic_pregunta).into(binding.ivItemS)
                        binding.tvNameS.text = it[idS].nombre.toUpperCase()
                        binding.tvMaterialS.text = getString(R.string.material, it[idS].material)
                        binding.tvDimensionChic.text = getString(R.string.dimensionChica,it[idS].chica)
                        binding.tvPrecioS.text =
                                getString(R.string.precio, formatter.format(it[idS].precio).toString())
                        binding.tvDimensionMed.text =
                                getString(R.string.dimensionMediana,it[idS].mediana)
                        binding.tvDimensionGran.text =
                                getString(R.string.dimensionGrande, it[idS].grande)
                        binding.tvDimensionXL.isVisible = false
                        binding.tvCantidadS.text = getString(R.string.cantidad, it[idS].cantidad)
                        botones()
                    }
                })
            }
            "DyeAndBee" -> categoria?.let {
                viewModel.selectedDAB().observe(viewLifecycleOwner, {
                    it?.let {
                        if (it[idS].chica.isEmpty()) {
                            binding.tvDimensionChic.isVisible = false
                        }
                        if (it[idS].mediana.isEmpty()) {
                            binding.tvDimensionMed.isVisible = false
                        }
                        if (it[idS].grande.isEmpty()) {
                            binding.tvDimensionGran.isVisible = false
                        }
                        if (it[idS].extraGrande.isEmpty()) {
                            binding.tvDimensionXL.isVisible = false
                        }
                        Glide.with(binding.ivItemS).load(it[idS].urlImage).circleCrop()
                                .placeholder(R.drawable.ic_pregunta).into(binding.ivItemS)
                        binding.tvNameS.text = it[idS].nombre.toUpperCase()
                        binding.tvMaterialS.text =
                                getString(R.string.material, it[idS].material)
                        binding.tvDimensionChic.text =
                                getString(R.string.dimensionChica,it[idS].chica)
                        binding.tvPrecioS.text =
                                getString(R.string.precio, formatter.format(it[idS].precio).toString())
                        binding.tvDimensionMed.text =
                                getString(R.string.dimensionMediana,it[idS].mediana)
                        binding.tvDimensionGran.text =
                                getString(R.string.dimensionGrande, it[idS].grande)
                        binding.tvDimensionXL.text =
                                getString(R.string.dimensionXL, it[idS].extraGrande)
                        binding.tvCantidadS.text = getString(R.string.cantidad, it[idS].cantidad)
                        botones()
                    }
                })
            }
        }
    }

    private fun botones(){
        binding.tvCantidad.text = cant.toString()
        binding.ibAgregarCarrito.isClickable = false
        binding.btnMas.setOnClickListener {
            if (cant < 5){
                cant++
                binding.tvCantidad.text = cant.toString()
            } else {
                cant = 5
                binding.tvCantidad.text = cant.toString()
            }
            binding.ibAgregarCarrito.isClickable = cant != 0
        }
        binding.btnMenos.setOnClickListener {
            if (cant > 0){
                cant--
                binding.tvCantidad.text = cant.toString()
            } else {
                cant = 0
                binding.tvCantidad.text = cant.toString()
            }
            binding.ibAgregarCarrito.isClickable = cant != 0
        }

    }
}