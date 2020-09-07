package com.chirag.randompeoplecarouseltest.utils

import com.chirag.randompeoplecarouseltest.model.Location
import com.chirag.randompeoplecarouseltest.model.Name


/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
/**
 * Function to return display name from Name object
 * @param name is Object of Name data class
 * @return displayName String
 */
fun getDisplayName(name: Name?): String {
    var displayName = ""
    name?.let {
        displayName = "${it.first} ${it.last}"
    }
    return displayName
}

/**
 * Function to return display address from Location object
 * @param location is Object of Location data class
 * @return displayAddress String
 */
fun getDisplayAddress(location: Location?): String {
    var displayAddress = ""
    location?.let {
        displayAddress =
            "${it.street}, ${it.city}, ${it.state} - ${it.zip}"
    }
    return displayAddress
}