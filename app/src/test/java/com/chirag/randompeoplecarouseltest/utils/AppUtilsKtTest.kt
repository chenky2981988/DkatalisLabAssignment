package com.chirag.randompeoplecarouseltest.utils

import com.chirag.randompeoplecarouseltest.model.Location
import com.chirag.randompeoplecarouseltest.model.Name
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Chirag Sidhiwala on 7/9/20.
 */
@RunWith(JUnit4::class)
class AppUtilsKtTest {


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDisplayName() {
        val name: Name = Name("mr", "John", "Doe")
        val expectedOutput = "John Doe"
        assertEquals(expectedOutput, getDisplayName(name))

        val emptyExpectedOutput = ""
        assertEquals(emptyExpectedOutput, getDisplayName(null))
    }

    @Test
    fun getDisplayAddress() {
        val location = Location("2527, terry In", "albany", "missuri", "77190")
        val expectedOutput = "2527, terry In, albany, missuri - 77190"
        assertEquals(expectedOutput, getDisplayAddress(location))

        val emptyExpectedOutput = ""
        assertEquals(emptyExpectedOutput, getDisplayAddress(null))
    }
}