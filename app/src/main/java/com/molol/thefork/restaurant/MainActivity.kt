package com.molol.thefork.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button40370.setOnClickListener {
            openCard(40370)
        }
        button14163.setOnClickListener {
            openCard(14163)
        }
        button16404.setOnClickListener {
            openCard(16404)
        }

    }


    fun openCard(restaurantId:Int) {
        val intent = RestauranCardActivity.newIntent(this, restaurantId )
        startActivity(intent)
    }
}
