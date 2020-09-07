package com.chirag.randompeoplecarouseltest.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chirag.randompeoplecarouseltest.database.dao.FavouritePeopleDao
import com.chirag.randompeoplecarouseltest.model.User
import com.chirag.randompeoplecarouseltest.viewmodel.FavouriteViewModel
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
@RunWith(JUnit4::class)
class FavouritePeopleRepositoryTest {

    @Mock
    private lateinit var favouritePeopleDao: FavouritePeopleDao

    private lateinit var favouritePeopleRepository: FavouritePeopleRepository

    private var favouriteListMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    private var favouriteListLiveData: LiveData<List<User>> = favouriteListMutableLiveData

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        favouritePeopleRepository = FavouritePeopleRepository(favouritePeopleDao)
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
            this.favouritePeopleDao.getFavouritePeopleList()
        ).thenAnswer {
            return@thenAnswer favouriteListLiveData
        }

        favouritePeopleRepository.getListOfFavouritePeople()?.observeForever {
            Assert.assertTrue("Verify Favourite User List with DB", (it is List<User>))
        }
    }
}