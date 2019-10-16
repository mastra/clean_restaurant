package com.molol.thefork.restaurant.domain

import com.molol.thefork.core.restaurant.domain.Restaurant

fun RestaurantData.toRestaurant() : Restaurant {
    var picList : List<String> = picsDiaporama.map { it.x270}

    return Restaurant( idRestaurant, name, picsMain.x270, picList)
}