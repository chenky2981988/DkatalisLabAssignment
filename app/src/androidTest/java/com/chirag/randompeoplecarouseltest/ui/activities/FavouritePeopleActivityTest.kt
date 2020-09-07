package com.chirag.randompeoplecarouseltest.ui.activities

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.chirag.randompeoplecarouseltest.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FavouritePeopleActivityTest {

    lateinit var mMainActivityRule: ActivityTestRule<MainActivity>

    @Before
    fun callOnBefore() {
        InstrumentationRegistry.getInstrumentation().targetContext.deleteDatabase("favourite_people_database")
        mMainActivityRule = ActivityTestRule(MainActivity::class.java)
        mMainActivityRule.launchActivity(Intent())
        Thread.sleep(5000)
    }

    @Test
    fun emptyListTest() {
        onView(withId(R.id.favourite_button)).perform(ViewActions.click())
        Thread.sleep(2000)
        onView(withId(R.id.no_favourite_people)).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun favouritePeopleListTest() {
        onView(withId(R.id.swipeView)).perform(ViewActions.swipeRight())
        Thread.sleep(5000)
        onView(withId(R.id.favourite_button)).perform(ViewActions.click())
        Thread.sleep(2000)
        onView(withId(R.id.favourite_people_rv)).check(
            matches(
                isDisplayed()
            )
        )
    }

}