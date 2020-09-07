package com.chirag.randompeoplecarouseltest.networking

import com.chirag.randompeoplecarouseltest.model.RandomPeopleModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
interface ApiService {

    @GET("api/0.4/")
    suspend fun getRandomUser(@Query("randomapi") randomapi: String): Response<RandomPeopleModel>
}