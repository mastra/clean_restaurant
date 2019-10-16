package com.molol.thefork.restaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.molol.thefork.restaurant.ui.presentation.RestauranCardFragment

class RestauranCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restauran_card_activity)
        val restaurantId = intent.extras?.getInt( RESTAURANT_ID) ?: 0
        if (savedInstanceState == null) {

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RestauranCardFragment.newInstance(restaurantId))
                .commitNow()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val RESTAURANT_ID = "restaurant_id"

        fun newIntent(context: Context, restaurantId: Int): Intent {
            val intent = Intent(context, RestauranCardActivity::class.java)
            intent.putExtra(RESTAURANT_ID, restaurantId)
            return intent
        }
    }
}
