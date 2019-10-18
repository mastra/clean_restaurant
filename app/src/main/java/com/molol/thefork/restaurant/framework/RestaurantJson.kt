package com.molol.thefork.restaurant.framework

import com.molol.thefork.restaurant.domain.RestaurantData
import com.molol.thefork.restaurant.domain.RestaurantResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object  RestaurantJson {
    fun parse(strJson: String) : RestaurantData? {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter = moshi.adapter<RestaurantResponse>(RestaurantResponse::class.java!!)

        val response = jsonAdapter.fromJson(strJson)
        return response?.restaurant
    }
}