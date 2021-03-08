package com.mohan.country.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mohan.country.R
import com.mohan.country.databinding.FragmentDetailBinding
import com.mohan.country.model.Country


class DetailFragment : Fragment() {

    private lateinit var detailFragmentBinding: FragmentDetailBinding
    private lateinit var country: Country

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        detailFragmentBinding.lifecycleOwner = viewLifecycleOwner
        return detailFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        country = arguments?.getSerializable("obj") as Country
        detailFragmentBinding.item = country
    }

}