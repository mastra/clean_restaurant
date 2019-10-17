package com.molol.thefork.restaurant.ui.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.molol.thefork.restaurant.R
import com.molol.thefork.restaurant.RestauranCardActivity
import kotlinx.android.synthetic.main.restauran_card_fragment.*

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

    private lateinit var viewModel: RestauranCardViewModel
    private lateinit var binding: com.molol.thefork.restaurant.databinding.RestauranCardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val restaurantId = arguments!!.getInt(RestauranCardActivity.RESTAURANT_ID)
        viewModel = ViewModelProviders.of(this).get(RestauranCardViewModel::class.java)


        binding = DataBindingUtil.inflate(inflater, R.layout.restauran_card_fragment, container, false)

        binding.restauranCardViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.show(restaurantId)

        viewModel.restaurant.observe(this, Observer {newRestaurant ->
            binding.imageSlider.setSliderAdapter(DiaporamaSliderAdapter(context!!, newRestaurant.picDiaporama));

        })


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
