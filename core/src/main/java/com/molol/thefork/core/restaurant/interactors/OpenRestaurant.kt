package com.molol.thefork.core.restaurant.interactors

import com.molol.thefork.core.restaurant.data.RestaurantRepository

class OpenRestaurant(private val restaurantRepository: RestaurantRepository) {
    operator fun invoke(restaurantId: Int) = restaurantRepository.getRestaurant(restaurantId)
}