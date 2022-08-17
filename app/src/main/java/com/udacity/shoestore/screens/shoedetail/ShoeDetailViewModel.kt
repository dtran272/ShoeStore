package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _isFormDirty = MutableLiveData<Boolean>()
    val isFormDirty: LiveData<Boolean>
        get() = _isFormDirty

    init {
        _isFormDirty.value = false
    }

    fun onTextChanged() {
        _isFormDirty.value = true
    }
}