package com.molol.thefork.restaurant.ui.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.molol.thefork.restaurant.R
import com.molol.thefork.restaurant.RestauranCardActivity
import kotlinx.android.synthetic.main.restauran_card_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

class RestauranCardFragment : Fragment() {



    companion object {
        fun newInstance(restaurantId: Int) : RestauranCardFragment {

            val instance = RestauranCardFragment()
            instance.arguments = Bundle().apply {
                putInt(RestauranCardActivity.RESTAURANT_ID, restaurantId)
            }
            return instance
        }
    }

    //private lateinit var viewModel: RestauranCardViewModel
    val restaurantViewModel: RestauranCardViewModel by viewModel()

    private lateinit var binding: com.molol.thefork.restaurant.databinding.RestauranCardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val restaurantId = arguments!!.getInt(RestauranCardActivity.RESTAURANT_ID)
        //viewModel = ViewModelProviders.of(this).get(RestauranCardViewModel::class.java)


        binding = DataBindingUtil.inflate(inflater, R.layout.restauran_card_fragment, container, false)

        binding.restauranCardViewModel = restaurantViewModel

        binding.setLifecycleOwner(this)

        restaurantViewModel.show(restaurantId)

        restaurantViewModel.restaurant.observe(this, Observer {newRestaurant ->
            binding.imageSlider.setSliderAdapter(DiaporamaSliderAdapter(context!!, newRestaurant.picDiaporama));

            newRestaurant.startMenu?.forEach {
                val menuItemView = CarteMenuItemView(context!!)
                menuItemView.text = it.name
                menuItemView.price = it.price.str + it.price.currencySymbol
                binding.startLayout.addView( menuItemView)
            }
            //binding.restaurancard.requestLayout()

            newRestaurant.mainMenu?.forEach {
                val menuItemView = CarteMenuItemView(context!!)
                menuItemView.text = it.name
                menuItemView.price = it.price.str + it.price.currencySymbol
                binding.mainLayout.addView( menuItemView)
            }
            newRestaurant.dessertMenu?.forEach {
                val menuItemView = CarteMenuItemView(context!!)
                menuItemView.text = it.name
                menuItemView.price = it.price.str + it.price.currencySymbol
                binding.dessertLayout.addView( menuItemView)
            }

            binding.ratingBar.rating = newRestaurant.tripAdvisorRate

            val df = DecimalFormat.getInstance()
            binding.textViewRate.text = df.format(newRestaurant.avgRate)
            binding.textViewAvisRate.text = df.format(newRestaurant.avgRate)
        })

        restaurantViewModel.loading.observe(this, Observer { newLoading ->
            binding.loadingLayout.visibility = if (newLoading) View.VISIBLE else View.GONE
            binding.progressBar.visibility = if (newLoading) View.VISIBLE else View.GONE
            //binding.progressBar.set
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
