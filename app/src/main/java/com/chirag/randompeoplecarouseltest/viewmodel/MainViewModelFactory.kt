package com.chirag.randompeoplecarouseltest.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chirag.randompeoplecarouseltest.database.FavouritePeopleDatabase
import com.chirag.randompeoplecarouseltest.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
/**
 * Factory class to create ViewModel object
 */
@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                mainRepository = MainRepository(FavouritePeopleDatabase.getInstance(context)?.favouritePeopleDao)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}