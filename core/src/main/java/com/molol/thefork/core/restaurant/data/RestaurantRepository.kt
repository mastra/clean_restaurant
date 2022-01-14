package com.molol.thefork.core.restaurant.data

import com.molol.thefork.core.restaurant.domain.Restaurant

class RestaurantRepository(private val dataSource: RestaurantDataSource) {

    fun getRestaurant(restaurantId: Int) : Restaurant?
        = dataSource.get(restaurantId)
}