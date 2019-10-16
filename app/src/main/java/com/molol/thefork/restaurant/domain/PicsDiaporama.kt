package com.molol.thefork.restaurant.domain

import com.squareup.moshi.Json

data class PicsDiaporama(
    val label: String,
    @Json(name = "240x135")
    val x135: String,
    @Json(name = "480x270")
    val x270: String,
    @Json(name = "612x344")
    val x344: String,
    @Json(name = "664x374")
    val x374: String,
    @Json(name = "1350x759")
    val x759: String
)