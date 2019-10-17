package com.molol.thefork.restaurant.ui.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import com.molol.thefork.restaurant.R
import kotlinx.android.synthetic.main.carte_menu_item_view.view.*


class CarteMenuItemView : LinearLayout {

    var text : String?  = ""
        set(value ) {
            textViewMenuItemTitle.text = value
            field = value
        }

    var price : String? = ""
        set(value ) {
            textViewMenuItemPrice.text = value
            field = value
        }

            constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes( attrs, R.styleable.CarteMenuItemView, defStyle, 0)

        text = a.getString( R.styleable.CarteMenuItemView_carte_menu_item_text )
        price = a.getString( R.styleable.CarteMenuItemView_carte_menu_item_price  )
    }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.carte_menu_item_view, this, true)
        layoutParams = LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT )
            .apply { setMargins(0,32,0,32)}

        orientation = HORIZONTAL
    }

}
