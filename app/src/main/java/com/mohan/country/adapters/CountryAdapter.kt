package com.mohan.country.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mohan.country.R
import com.mohan.country.callbacks.CountryClick
import com.mohan.country.databinding.LayoutCountryBinding
import com.mohan.country.model.Country
import java.util.*
import kotlin.collections.ArrayList

class CountryAdapter(
    private var it: List<Country>,
    private val requireActivity: FragmentActivity
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(), Filterable {

    private var countryFilterList = ArrayList<Country>()

    init {
        countryFilterList = it as ArrayList<Country>
    }

    private var onQuoteitemClickListener: CountryClick? = null


    fun setOnItmClickListener(onQuoteitemClickListener: CountryClick) {
        this.onQuoteitemClickListener = onQuoteitemClickListener
    }

    inner class ViewHolder(val binder: LayoutCountryBinding) : RecyclerView.ViewHolder(binder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(requireActivity),
                R.layout.layout_country,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countryFilterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binder.item = countryFilterList[position]
        val item = countryFilterList[position]
        holder.binder.textViewName.setOnClickListener {
            if (onQuoteitemClickListener != null) onQuoteitemClickListener?.onCallClick(
                item,
                holder.binder.textViewName
            )
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    countryFilterList = it as ArrayList<Country>
                } else {
                    val resultList = ArrayList<Country>()
                    for (row in it) {
                        if (row.name.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    countryFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as ArrayList<Country>
                notifyDataSetChanged()
            }
        }
    }
}