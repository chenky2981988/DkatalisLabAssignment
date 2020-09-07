package com.chirag.randompeoplecarouseltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chirag.randompeoplecarouseltest.database.dao.FavouritePeopleDao
import com.chirag.randompeoplecarouseltest.model.RandomPeopleModel
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.networking.ServerResponse
import com.chirag.randompeoplecarouseltest.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val randomUserMutableLiveData = MutableLiveData<ServerResponse<RandomPeopleModel>>()
    val randomUserLiveData: LiveData<ServerResponse<RandomPeopleModel>> =
        randomUserMutableLiveData

    fun getRandomUser() {
        viewModelScope.launch {
            mainRepository.callRandomUserApi().collect {
                randomUserMutableLiveData.value = it
            }
        }
    }

    fun insertFavouritePeople(user: User) {
        viewModelScope.launch {
            mainRepository.insertFavouritePeople(user)
        }
    }

}