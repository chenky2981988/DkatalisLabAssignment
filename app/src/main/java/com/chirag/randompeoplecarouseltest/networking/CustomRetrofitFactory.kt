package com.chirag.randompeoplecarouseltest.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
//Singleton Retrofit Factory class
object CustomRetrofitFactory {

    private val BASE_URL = "https://randomuser.me/" //Base URL endpoint
    /*private val gson = GsonBuilder() // Gson Factory converter
        .setDateFormat("yyyy-MM-dd")
        .setLenient()
        .create()*/

    //Get object of ApiService class
    fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}