package com.molol.thefork.restaurant.domain


import com.molol.thefork.core.restaurant.domain.Price
import com.molol.thefork.core.restaurant.domain.Restaurant
import java.util.*

fun RestaurantData.toRestaurant() : Restaurant {
    var picList : List<String> = picsDiaporama.map { it.x270}


    var currencySymbol = when( currencyCode) {
        "EUR" -> Currency.getInstance(Locale.FRANCE).symbol
        else -> Currency.getInstance(Locale.US).symbol
    }
    val avgPrice = Price(  cardPrice, currencyCode, currencySymbol )

    return Restaurant( idRestaurant, name, picsMain.x270, picList, avgPrice, speciality, rateCount, avgRate, tripAdvisorAvgRating, tripAdvisorReviewCount)
    }
