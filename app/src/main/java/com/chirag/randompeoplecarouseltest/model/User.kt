package com.chirag.randompeoplecarouseltest.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.chirag.randompeoplecarouseltest.database.FAVOURITE_PEOPLE_TABLE
import kotlinx.android.parcel.Parcelize


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@Entity(tableName = FAVOURITE_PEOPLE_TABLE)
@Parcelize
@TypeConverters(NameTypeConverter::class, LocationTypeConverter::class)
data class User(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val username: String,
    val password: String,
    val salt: String,
    @PrimaryKey
    val md5: String,
    val sha1: String,
    val sha256: String,
    val registered: String,
    val dob: String,
    val phone: String,
    val cell: String,
    val SSN: String,
    val picture: String
) : Parcelable