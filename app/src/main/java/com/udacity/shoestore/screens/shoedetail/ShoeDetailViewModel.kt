package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    private val _shoeSize = MutableLiveData<Double>()
    val shoeSize: LiveData<Double>
        get() = _shoeSize

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _shoeName

    private val _isFormDirty = MutableLiveData<Boolean>()
    val isFormDirty: LiveData<Boolean>
        get() = _isFormDirty

    init {
        _shoeName.value = null
        _shoeSize.value = null
        _company.value = null
        _description.value = null
        _isFormDirty.value = false
    }

    fun onTextChanged() {
        _isFormDirty.value = true
    }
}