package com.mohan.country.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mohan.country.model.Country
import com.mohan.country.repo.ContryRepo
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeRepository = ContryRepo.getInstance(application)

    val countryListLiveData: LiveData<List<Country>> = liveData(Dispatchers.IO) {
        emitSource(employeeRepository.getAllCountryLiveData())
    }
}