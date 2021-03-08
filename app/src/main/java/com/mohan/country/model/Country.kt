package com.mohan.country.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "country_table")
data class Country (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val topLevelDomain : List<String>,
    val alpha2Code : String,
    val alpha3Code : String,
    val callingCodes : List<String>,
    val capital : String,
    val altSpellings : List<String>,
    val region : String,
    val subregion : String,
    val population : Int,
    val latlng : List<Double>,
    val demonym : String,
    val area : Double,
    val gini : Double,
    val timezones : List<String>,
    val borders : List<String>,
    val nativeName : String,
    val numericCode : String?,
    val currencies : List<Currencies>,
    val languages : List<Languages>,
    val translations : Translations,
    val flag : String,
    val regionalBlocs : List<RegionalBlocs>,
    val cioc : String?
    ) : Serializable

data class Currencies (
    val code : String,
    val name : String,
    val symbol : String
    )

data class Languages (
    val iso639_1 : String,
    val iso639_2 : String,
    val name : String,
    val nativeName : String
    )

data class RegionalBlocs (
    val acronym : String,
    val name : String,
    val otherAcronyms : List<String>,
    val otherNames : List<String>
    )

data class Translations (
    val de : String,
    val es : String,
    val fr : String,
    val ja : String,
    val it : String,
    val br : String,
    val pt : String,
    val nl : String,
    val hr : String,
    val fa : String
    )