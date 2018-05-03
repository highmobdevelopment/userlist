package com.erevacation.widgets.cards

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.erevacation.widgets.R
import com.erevacation.widgets.databinding.CardProfileBinding

class ProfileCard : FrameLayout {

    var binding : CardProfileBinding? = null
    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        binding = DataBindingUtil.inflate(inflater, R.layout.card_profile, this, false)

        val view = binding?.root

        this.addView(view)

    }

    fun setListApperance(image:String, name:String, email:String) {
        binding?.name?.text = name
        binding?.email?.text = email
        binding?.profileImage?.setImageURI(Uri.parse(image))
    }
}