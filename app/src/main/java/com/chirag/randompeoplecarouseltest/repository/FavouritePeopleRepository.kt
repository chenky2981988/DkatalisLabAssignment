package com.chirag.randompeoplecarouseltest.repository

import androidx.lifecycle.LiveData
import com.chirag.randompeoplecarouseltest.database.dao.FavouritePeopleDao
import com.chirag.randompeoplecarouseltest.model.User


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
class FavouritePeopleRepository(private val favouritePeopleDao: FavouritePeopleDao?) {
    fun getListOfFavouritePeople(): LiveData<List<User>>? {
        return favouritePeopleDao?.getFavouritePeopleList()
    }
}