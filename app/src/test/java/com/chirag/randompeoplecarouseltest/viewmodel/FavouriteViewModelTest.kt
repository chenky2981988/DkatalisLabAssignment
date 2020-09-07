package com.chirag.randompeoplecarouseltest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.repository.FavouritePeopleRepository
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
@RunWith(JUnit4::class)
class FavouriteViewModelTest {

    /*@Mock
    private lateinit var context: Application*/

    @Mock
    private lateinit var favouritePeopleRepository: FavouritePeopleRepository

    private lateinit var favouriteViewModel: FavouriteViewModel

    private var favouriteListMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    private var favouriteListLiveData: LiveData<List<User>> = favouriteListMutableLiveData

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //Mockito.`when`<Context>(context.applicationContext).thenReturn(context)
        favouriteViewModel = FavouriteViewModel(favouritePeopleRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getListOfFavouritePeople() {

        val favouriteList = listOf<User>()
        favouriteListMutableLiveData.value = favouriteList
        favouriteListLiveData = favouriteListMutableLiveData

        Mockito.`when`(
            this.favouritePeopleRepository.getListOfFavouritePeople()
        ).thenAnswer {
            return@thenAnswer favouriteListLiveData
        }

        favouriteViewModel.getListOfFavouritePeople()?.observeForever {
            Assert.assertTrue("Verify Favourite User List", (it is List<User>))
        }
    }
}