package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        _shoes.value = getShoeList()
    }

    private fun getShoeList(): List<Shoe> {
        return mutableListOf(
            Shoe("Air Jordan", 8.0, "Nike", "Air Jordan from Nike"),
            Shoe("NB 1", 10.0, "New Balances", "NB1 from New Balances"),
            Shoe("Classic", 10.5, "Vans", "Classic from Vans"),
            Shoe("CrossFit 1", 9.5, "Reebok", "CrossFit1 from Reebok")
        )
    }
}