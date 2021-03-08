package com.mohan.country.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken
import com.mohan.country.model.Currencies
import com.mohan.country.model.Languages
import com.mohan.country.model.RegionalBlocs
import com.mohan.country.model.Translations


class Converters {

    @TypeConverter
    fun fromString(value: String?): List<String?>? {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayLisr(list: List<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromInt(value: String?): List<Int?>? {
        val listType: Type = object : TypeToken<List<Int?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayInt(list: List<Int?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromRB(value: String?): List<RegionalBlocs?>? {
        val listType: Type = object : TypeToken<List<RegionalBlocs?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromLisrRB(list: List<RegionalBlocs?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromLang(value: String?): List<Languages?>? {
        val listType: Type = object : TypeToken<List<Languages?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromLisrLang(list: List<Languages?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromCurrencies(value: String?): List<Currencies?>? {
        val listType: Type = object : TypeToken<List<Currencies?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayCurrencies(list: List<Currencies?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromTranslations(value: String?): Translations? {
        val listType: Type = object : TypeToken<Translations?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayTranslations(list: Translations?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromDouble(value: String?): List<Double?>? {
        val listType: Type = object : TypeToken<List<Double?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayDouble(list: List<Double?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}