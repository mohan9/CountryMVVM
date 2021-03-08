package com.mohan.country.api

import com.mohan.country.model.Country
import retrofit2.http.GET

interface CountryEndpoints {
    @GET("/rest/v2/all")
    suspend fun getCountryList(): List<Country>
}