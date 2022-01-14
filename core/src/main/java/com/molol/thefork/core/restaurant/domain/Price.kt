package com.molol.thefork.core.restaurant.domain

import java.text.DecimalFormat

data class Price(
    val number: Float,
    val currencyCode: String,
    val currencySymbol: String) {
    val df = DecimalFormat.getInstance()
    val str = df.format(number)

}