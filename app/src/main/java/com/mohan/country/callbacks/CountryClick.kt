package com.mohan.country.callbacks

import android.widget.TextView
import com.mohan.country.model.Country

interface CountryClick {
    fun onCallClick(id: Country, textViewName: TextView)
}