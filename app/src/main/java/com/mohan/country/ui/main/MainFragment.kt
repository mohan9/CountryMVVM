package com.mohan.country.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohan.country.R
import com.mohan.country.adapters.CountryAdapter
import com.mohan.country.callbacks.CountryClick
import com.mohan.country.databinding.MainFragmentBinding
import com.mohan.country.model.Country

class MainFragment : Fragment(), CountryClick {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mainFragmentBinding: MainFragmentBinding
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var list: List<Country>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        mainFragmentBinding.lifecycleOwner = viewLifecycleOwner
        return mainFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainFragmentBinding.model = viewModel
        mainFragmentBinding.recyclerviewCountry.layoutManager =
            LinearLayoutManager(requireActivity())

        viewModel.countryListLiveData.observe(viewLifecycleOwner, Observer {
            mainFragmentBinding.progressCircular.visibility = when {
                it.isEmpty() -> View.VISIBLE
                else -> View.GONE

            }
            if (it.isNotEmpty()) {
                list = it
                setAdapter(it)
            }
            Log.e("response", it.toString())
        })

        mainFragmentBinding.countrySearch.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                countryAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun setAdapter(it: List<Country>?) {
        if (it != null) {
            countryAdapter = CountryAdapter(it, requireActivity())
            countryAdapter.setOnItmClickListener(this)
            mainFragmentBinding.recyclerviewCountry.adapter = countryAdapter
        }
    }

    override fun onCallClick(id: Country, textViewName: TextView) {
        val bundle = Bundle()
        bundle.putSerializable("obj", id)
        Navigation.findNavController(textViewName)
            .navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }

}