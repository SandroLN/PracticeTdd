package com.sandroln.practicetdd

import org.junit.Assert.assertEquals
import org.junit.Test

class NumbersTest {

    @Test
    fun test_sum() {
        val numbers: Numbers = Numbers.Base(12, 4)
        val actual = numbers.sum()
        val expected = 16
        assertEquals(expected, actual)
    }

    @Test
    fun test_difference(){
        val numbers: Numbers = Numbers.Base(12, 4)
        val actual = numbers.difference()
        val expected = 8
        assertEquals(expected, actual)
    }
}