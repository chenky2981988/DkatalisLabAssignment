package com.chirag.randompeoplecarouseltest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
@Parcelize
data class Location(val street: String, val city: String, val state: String, val zip: String) :
    Parcelable