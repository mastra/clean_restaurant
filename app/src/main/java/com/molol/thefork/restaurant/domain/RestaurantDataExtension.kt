package com.molol.thefork.restaurant.domain


import com.molol.thefork.core.restaurant.domain.MenuItem
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
    val startMenu = mutableListOf<MenuItem>().apply {
        add(MenuItem(cardStart1, Price(priceCardStart1, currencyCode, currencySymbol)))
        add(MenuItem(cardStart2, Price(priceCardStart2, currencyCode, currencySymbol)))
        add(MenuItem(cardStart3, Price(priceCardStart3, currencyCode, currencySymbol)))
    }

    val mainMenu = mutableListOf<MenuItem>().apply {
        add(MenuItem(cardMain1, Price(priceCardMain1, currencyCode, currencySymbol)))
        add(MenuItem(cardMain2, Price(priceCardMain2, currencyCode, currencySymbol)))
        add(MenuItem(cardMain3, Price(priceCardMain3, currencyCode, currencySymbol)))
    }
    val dessertMenu = mutableListOf<MenuItem>().apply {
        add(MenuItem(cardDessert1, Price(priceCardDessert1, currencyCode, currencySymbol)))
        add(MenuItem(cardDessert2, Price(priceCardDessert2, currencyCode, currencySymbol)))
        add(MenuItem(cardDessert3, Price(priceCardDessert3, currencyCode, currencySymbol)))
    }
    // The restaurant id given doesn't have an avgRate, so I will assign some value just to show something
    val avg = avgRate ?: 8.1f

    return Restaurant( idRestaurant, name, picsMain.x270, picList, avgPrice, speciality, rateCount, avg,
        tripAdvisorAvgRating, tripAdvisorReviewCount,
        startMenu, mainMenu, dessertMenu
        )
    }
