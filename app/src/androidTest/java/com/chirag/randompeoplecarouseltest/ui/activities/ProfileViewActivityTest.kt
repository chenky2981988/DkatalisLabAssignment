package com.chirag.randompeoplecarouseltest.ui.activities

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
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
class ProfileViewActivityTest {

    lateinit var mMainActivityRule: ActivityTestRule<MainActivity>

    @Before
    fun callOnBefore() {
        InstrumentationRegistry.getInstrumentation().targetContext.deleteDatabase("favourite_people_database")
        mMainActivityRule = ActivityTestRule(MainActivity::class.java)
        mMainActivityRule.launchActivity(Intent())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.swipeView)).perform(ViewActions.swipeRight())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.favourite_button)).perform(ViewActions.click())
        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.favourite_people_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Thread.sleep(2000)
    }

    @Test
    fun verifyPeopleProfile() {
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.profile_imageview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_title_data))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_birthday))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_location))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_call))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_email))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profile_password))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.profile_birthday)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.profile_location)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.profile_call)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.profile_email)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.profile_password)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.profile_name)).perform(ViewActions.click())
    }
}