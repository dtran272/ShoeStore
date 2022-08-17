package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoedetailBinding
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoedetail, container, false)

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        setupButtons()

        viewModel.isFormDirty.observe(viewLifecycleOwner, Observer { isFormDirty ->
            if (isFormDirty) {
                binding.saveButton.alpha = 1f
                binding.saveButton.isEnabled = true
                binding.saveButton.isClickable = true
            }
        })

        return binding.root
    }


    private fun setupButtons() {
        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(null))
        }

        binding.saveButton.setOnClickListener { view ->

            val shoSize = if (binding.shoeSize.text.toString().isNotBlank()) binding.shoeSize.text.toString().toDouble() else 0.0

            val newShoe = Shoe(
                binding.shoeName.text.toString(),
                shoSize,
                binding.companyName.text.toString(),
                binding.description.text.toString()
            )


            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(newShoe))
        }
    }
}