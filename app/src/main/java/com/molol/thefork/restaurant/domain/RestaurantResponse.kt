package com.molol.thefork.restaurant.domain


import com.squareup.moshi.Json

data class RestaurantResponse(
    @Json(name = "data")
    val restaurant: RestaurantData,
    val result: Int,
    val resultMsg: String?
)