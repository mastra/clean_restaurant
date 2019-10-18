package com.molol.thefork.restaurant

import android.app.Application
import com.molol.thefork.core.restaurant.data.RestaurantDataSource
import com.molol.thefork.core.restaurant.data.RestaurantRepository
import com.molol.thefork.core.restaurant.interactors.OpenRestaurant
import com.molol.thefork.restaurant.framework.APIRestaurantDataSource
import com.molol.thefork.restaurant.ui.presentation.RestauranCardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RestaurantCardApplication : Application() {

    val appModule = module {


        factory<RestaurantDataSource> { APIRestaurantDataSource() }
        factory<RestaurantRepository> { RestaurantRepository( get() ) }
        factory<OpenRestaurant> { OpenRestaurant( get() ) }
        viewModel { RestauranCardViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@RestaurantCardApplication)
            modules(appModule)
        }
    }
}