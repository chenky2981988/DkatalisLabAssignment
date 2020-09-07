package com.chirag.randompeoplecarouseltest.repository

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import com.chirag.randompeoplecarouseltest.database.dao.FavouritePeopleDao
import com.chirag.randompeoplecarouseltest.model.RandomPeopleModel
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.networking.CustomRetrofitFactory
import com.chirag.randompeoplecarouseltest.networking.NetworkBoundRepository
import com.chirag.randompeoplecarouseltest.networking.ServerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@FlowPreview
@ExperimentalCoroutinesApi
class MainRepository(private val favouritePeopleDao: FavouritePeopleDao?) {
    fun callRandomUserApi(): Flow<ServerResponse<RandomPeopleModel>> {
        return object : NetworkBoundRepository<RandomPeopleModel>() {
            override suspend fun getDataFromServer(): Response<RandomPeopleModel> =
                CustomRetrofitFactory.getApiService().getRandomUser("")
        }.asFlow().flowOn(Dispatchers.IO)
    }

    suspend fun insertFavouritePeople(user: User?) {
        try {
            withContext(Dispatchers.IO) {
                user?.let {
                    favouritePeopleDao?.insert(it)
                }
            }
        } catch (ex: SQLiteConstraintException) {
            ex.printStackTrace()
        }
    }

}