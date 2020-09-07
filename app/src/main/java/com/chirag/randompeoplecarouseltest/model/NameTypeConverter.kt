package com.chirag.randompeoplecarouseltest.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
class NameTypeConverter {

    @TypeConverter
    fun toName(json: String): Name {
        val type = object : TypeToken<Name>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(name: Name): String {
        val type = object : TypeToken<Name>() {}.type
        return Gson().toJson(name, type)
    }
}