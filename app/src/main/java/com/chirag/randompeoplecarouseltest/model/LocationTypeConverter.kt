package com.chirag.randompeoplecarouseltest.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
class LocationTypeConverter {

    @TypeConverter
    fun toLocation(json: String): Location {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(location: Location): String {
        val type = object : TypeToken<Location>() {}.type
        return Gson().toJson(location, type)
    }
}