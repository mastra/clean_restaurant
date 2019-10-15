package com.molol.thefork.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.molol.thefork.core.restaurant.domain.Restaurant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val intent = RestauranCardActivity.newIntent(this, 40 )
            startActivity(intent)
        }
    }
}
