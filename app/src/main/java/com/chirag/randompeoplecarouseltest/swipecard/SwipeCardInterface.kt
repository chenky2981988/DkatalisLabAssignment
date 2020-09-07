package com.chirag.randompeoplecarouseltest.swipecard

import com.chirag.randompeoplecarouseltest.model.User


/**
 * Created by Chirag Sidhiwala on 6/9/20.
 */
interface SwipeCardInterface {
    fun onAccepted(user: User)
    fun onRejected()
}