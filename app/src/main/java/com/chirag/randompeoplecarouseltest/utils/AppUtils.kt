package com.chirag.randompeoplecarouseltest.utils

import com.chirag.randompeoplecarouseltest.model.Location
import com.chirag.randompeoplecarouseltest.model.Name


/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */

fun getDisplayName(name: Name?): String {
    var displayName = ""
    name?.let {
        displayName = "${it.first} ${it.last}"
    }
    return displayName
}

fun getDisplayAddress(location: Location?): String {
    var displayAddress = ""
    location?.let {
        displayAddress =
            "${it.street}, ${it.city}, ${it.state} - ${it.zip}"
    }
    return displayAddress
}