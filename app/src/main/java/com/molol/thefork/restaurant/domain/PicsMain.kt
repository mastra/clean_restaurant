package com.molol.thefork.restaurant.domain


import com.squareup.moshi.Json

data class PicsMain(
    @Json(name = "160x120")
    val x120: String,
    @Json(name = "240x135")
    val x135: String,
    @Json(name = "184x184")
    val x184: String,
    @Json(name = "480x270")
    val x270: String,
    @Json(name = "612x344")
    val x344: String,
    @Json(name = "664x374")
    val x374: String,
    @Json(name = "80x60")
    val x60: String,
    @Json(name = "1350x759")
    val x759: String,
    @Json(name = "92x92")
    val x92: String
)