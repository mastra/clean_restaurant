package com.molol.thefork.restaurant.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molol.thefork.core.restaurant.data.RestaurantRepository
import com.molol.thefork.core.restaurant.domain.Restaurant
import com.molol.thefork.core.restaurant.interactors.OpenRestaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestauranCardViewModel(val openRestaurant: OpenRestaurant) : ViewModel() {


    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private  val _restaurant = MutableLiveData<Restaurant>()
    val restaurant : LiveData<Restaurant>
        get() = _restaurant

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean>
        get() = _loading

    fun show(restautantId : Int) {

        viewModelScope.launch {
            _restaurant.value = withContext(Dispatchers.IO) {
                openRestaurant(restautantId)
            }
            hideLoading()
        }

    }

    fun showLoading() {
        _loading.value = true
    }

    fun hideLoading() {
        _loading.value = false
    }

}
