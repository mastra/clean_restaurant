package com.molol.thefork.core.restaurant.data

import com.molol.thefork.core.restaurant.domain.Restaurant

interface RestaurantDataSource {
    fun get( restaurantId: Int) : Restaurant?

}