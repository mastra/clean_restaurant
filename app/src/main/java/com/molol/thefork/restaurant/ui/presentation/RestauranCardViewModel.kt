package com.molol.thefork.restaurant.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molol.thefork.core.restaurant.domain.Restaurant
import com.molol.thefork.restaurant.framework.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestauranCardViewModel : ViewModel() {

    val repository = RestaurantRepository()

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private  val _restaurant = MutableLiveData<Restaurant>()
    val restaurant : LiveData<Restaurant>
        get() = _restaurant

    fun show(restautantId : Int) {

        viewModelScope.launch {
            _restaurant.value = withContext(Dispatchers.IO) {
                repository.getRestaurant(restautantId)
            }
        }

        //_title.value = "RestaurantData $restautantId"
        //_restaurant.value = Restaurant(restautantId,"RestaurantData $restautantId" )
    }
}
