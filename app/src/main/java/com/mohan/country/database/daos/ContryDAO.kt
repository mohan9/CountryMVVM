package com.mohan.country.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mohan.country.model.Country

@Dao
interface ContryDAO {
    @Insert
    fun insertCountry(country: Country)

    @Query("SELECT * FROM country_table")
    fun getAllCountryLiveData(): LiveData<List<Country>>

    @Query("DELETE FROM country_table")
    fun deleteAll()
}