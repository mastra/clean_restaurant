package com.molol.thefork.restaurant.domain

import com.squareup.moshi.Json
import java.util.*

data class RestaurantData(
    val address: String,
    @Json(name = "id_restaurant")
    val idRestaurant: Int,
    val name: String,
    @Json(name="card_price")
    val cardPrice: Float,
    @Json(name="rate_count")
    val rateCount: Int,
    @Json(name="avg_rate")
    val avgRate: Float?,

    @Json(name="trip_advisor_avg_rating")
    val tripAdvisorAvgRating: Float,
    @Json(name="trip_advisor_review_count")
    val tripAdvisorReviewCount: Int,

    @Json(name="currency_code")
    val currencyCode: String,

    @Json(name = "card_dessert_1")
    val cardDessert1: String,
    @Json(name = "card_dessert_2")
    val cardDessert2: String,
    @Json(name = "card_dessert_3")
    val cardDessert3: String,
    @Json(name = "card_main_1")
    val cardMain1: String,
    @Json(name = "card_main_2")
    val cardMain2: String,
    @Json(name = "card_main_3")
    val cardMain3: String,
    @Json(name = "card_start_1")
    val cardStart1: String,
    @Json(name = "card_start_2")
    val cardStart2: String,
    @Json(name = "card_start_3")
    val cardStart3: String,

    @Json(name = "price_card_dessert_1")
    val priceCardDessert1: Float,
    @Json(name = "price_card_dessert_2")
    val priceCardDessert2: Float,
    @Json(name = "price_card_dessert_3")
    val priceCardDessert3: Float,
    @Json(name = "price_card_main_1")
    val priceCardMain1: Float,
    @Json(name = "price_card_main_2")
    val priceCardMain2: Float,
    @Json(name = "price_card_main_3")
    val priceCardMain3: Float,
    @Json(name = "price_card_start_1")
    val priceCardStart1: Float,
    @Json(name = "price_card_start_2")
    val priceCardStart2: Float,
    @Json(name = "price_card_start_3")
    val priceCardStart3: Float,

    @Json(name = "pics_main")
    val picsMain: PicsMain,
    @Json(name = "pics_diaporama")
    val picsDiaporama: List<PicsDiaporama>,
    val speciality: String,
    @Json(name = "chef_name")
    val chefName: String?


)