package com.chirag.randompeoplecarouseltest.ui.activities

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Assert.*
import org.junit.Rule
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

}