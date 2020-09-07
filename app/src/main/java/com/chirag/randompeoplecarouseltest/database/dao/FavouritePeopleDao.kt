package com.chirag.randompeoplecarouseltest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chirag.randompeoplecarouseltest.model.User


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@Dao
interface FavouritePeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM FAVOURITE_PEOPLE_TABLE")
    fun getFavouritePeopleList(): LiveData<List<User>>
}