package com.chirag.randompeoplecarouseltest.ui.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.chirag.randompeoplecarouseltest.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var mMainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun launchActivityTest() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        onView(withId(R.id.favourite_button)).check(matches(isDisplayed()))

        Thread.sleep(5000)
        onView(withId(R.id.swipeView)).check(matches(isDisplayed()))

        onView(withId(R.id.profile_imageview)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_title)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_title_data)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_name)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_birthday)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_location)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_call)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_email)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_password)).check(matches(isDisplayed()))

        onView(withId(R.id.profile_birthday)).perform(ViewActions.click())
        onView(withId(R.id.profile_location)).perform(ViewActions.click())
        onView(withId(R.id.profile_call)).perform(ViewActions.click())
        onView(withId(R.id.profile_email)).perform(ViewActions.click())
        onView(withId(R.id.profile_password)).perform(ViewActions.click())
        onView(withId(R.id.profile_name)).perform(ViewActions.click())

        Thread.sleep(1000)
        onView(withId(R.id.favourite_button)).perform(ViewActions.click())

        onView(withId(R.id.favourite_people_rv)).check(matches(isDisplayed()))
    }
}