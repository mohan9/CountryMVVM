package com.mohan.country.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.mohan.country.api.CountryEndpoints
import com.mohan.country.api.RetroFitInstance
import com.mohan.country.database.CountryRoomDB
import com.mohan.country.database.daos.ContryDAO
import com.mohan.country.model.Country

class ContryRepo private constructor(application: Application) {

    private val contryDAO: ContryDAO = CountryRoomDB.getDatabase(application).getCountryDao()
    private val countryCall =
        RetroFitInstance.getInstanceRetrofit().create(CountryEndpoints::class.java)

    init {
    }

    suspend fun getAllCountryLiveData(): LiveData<List<Country>> {
        return contryDAO.getAllCountryLiveData().also {
            getAllCountryFromRemote()
        }
    }

    private suspend fun insertCountry(country: Country) {
        contryDAO.insertCountry(country)
    }

    private suspend fun deleteCountry() {
        contryDAO.deleteAll()
    }

    private suspend fun getAllCountryFromRemote() {
        try {
            val countryList = countryCall.getCountryList()
            deleteCountry()
            countryList.forEach {
                insertCountry(it)
            }
        } catch (exception: Throwable) {
            Log.e("error", exception.toString())
        }
    }

    // Singleton Pattern for Repository.
    companion object {
        private var INSTANCE: ContryRepo? = null
        fun getInstance(application: Application): ContryRepo = INSTANCE ?: kotlin.run {
            INSTANCE = ContryRepo(application = application)
            INSTANCE!!
        }
    }
}