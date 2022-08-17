package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoelistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoelist, container, false)

        (requireActivity() as MainActivity).viewModel.shoes.observe(viewLifecycleOwner, Observer { shoeList ->
            if (shoeList.isNotEmpty()) {
                shoeList.forEach { shoe ->
                    val shoeNameTextView = TextView(this.context)
                    shoeNameTextView.text = shoe.name

                    binding.shoeListLinearLayout.addView(shoeNameTextView)
                }
            }
        })

        setupButtons()
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun setupButtons() {
        binding.detailsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))
    }
}