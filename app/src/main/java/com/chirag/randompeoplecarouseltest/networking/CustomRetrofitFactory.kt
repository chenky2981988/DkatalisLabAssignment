package com.chirag.randompeoplecarouseltest.networking

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
object CustomRetrofitFactory {

    private val URL_ENDPOINT = "https://randomuser.me/"
    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .setLenient()
        .create()

    fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(URL_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService::class.java)
    }
}