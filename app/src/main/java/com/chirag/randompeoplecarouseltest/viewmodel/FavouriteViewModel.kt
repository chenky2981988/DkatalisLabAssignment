package com.chirag.randompeoplecarouseltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.repository.FavouritePeopleRepository


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
//Favourite People View Model
class FavouriteViewModel(private val favouritePeopleRepository: FavouritePeopleRepository) :
    ViewModel() {
    fun getListOfFavouritePeople(): LiveData<List<User>>? {
        return favouritePeopleRepository.getListOfFavouritePeople()
    }
}