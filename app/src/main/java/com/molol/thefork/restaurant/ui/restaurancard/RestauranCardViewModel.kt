package com.molol.thefork.restaurant.ui.restaurancard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestauranCardViewModel : ViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    fun show(restautantId : Int) {

        _title.value = "Restaurant $restautantId"

    }
}
