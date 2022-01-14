package com.molol.thefork.core.restaurant.domain

import java.util.*

data class Restaurant(val id:Int,
                      val name: String,
                      val picMain: String,
                      var picDiaporama: List<String>,
                      val cardPrice: Price,
                      val speciality: String,
                      val rateCount: Int,
                      val avgRate: Float?,
                      val tripAdvisorRate: Float,
                      val tripAdvisorCount: Int,
                      val startMenu: List<MenuItem>?,
                      val mainMenu: List<MenuItem>?,
                      val dessertMenu: List<MenuItem>?) {
}