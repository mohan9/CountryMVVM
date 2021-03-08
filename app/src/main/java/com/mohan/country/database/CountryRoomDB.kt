package com.mohan.country.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohan.country.database.daos.ContryDAO
import com.mohan.country.model.Country
import com.mohan.country.utils.Converters
import com.mohan.country.utils.ROOM_DB_NAME

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CountryRoomDB : RoomDatabase() {

    abstract fun getCountryDao(): ContryDAO

    companion object {
        private var INSTANCE: CountryRoomDB? = null

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                CountryRoomDB::class.java,
                ROOM_DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}