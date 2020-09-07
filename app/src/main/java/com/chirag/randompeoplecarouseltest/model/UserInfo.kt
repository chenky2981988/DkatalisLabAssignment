package com.chirag.randompeoplecarouseltest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@Parcelize
data class UserInfo(val user: User, val seed: String, val version: String) : Parcelable