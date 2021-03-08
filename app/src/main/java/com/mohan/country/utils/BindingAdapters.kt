package com.mohan.country.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mohan.country.model.Currencies
import com.mohan.country.model.Languages

@BindingAdapter("imageSrc")
fun setImageSrc(image: ImageView, url: String) {
    UtilsImageView.fetchSvg(image.context, url, image);
}

@BindingAdapter("population")
fun setPopulation(textView: TextView, population: Int) {
    textView.text = "Population : $population"
}

@BindingAdapter("region")
fun setRegion(textView: TextView, region: String) {
    textView.text = "Region : $region"
}

@BindingAdapter("lang")
fun setLang(textView: TextView, listLanguages: List<Languages>) {
    var lang = ""
    listLanguages.forEach { lang += "${it.name}, " }
    lang.trim()
    lang = if (lang.isNotEmpty()) lang.substring(0, lang.lastIndexOf(",")) else lang
    textView.text = "Languages : $lang"
}

@BindingAdapter("currencies")
fun setCurrencies(textView: TextView, currencies: List<Currencies>) {
    textView.text = "Currencies : ${currencies[0].name} ${currencies[0].symbol}"
}