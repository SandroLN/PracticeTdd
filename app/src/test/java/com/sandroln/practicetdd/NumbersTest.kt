package com.sandroln.practicetdd

import org.junit.Assert.assertEquals
import org.junit.Test

class NumbersTest {

    @Test
    fun test_sum_long(){
        val numbers: Numbers = Numbers.Base(2_000_000_000, 147483648)
        val isSumLong = numbers.isSumLong()
        val expected = true
        assertEquals(expected, isSumLong)
        val actual: Long = numbers.sumLong()
        val expectedNumber: Long = Int.MAX_VALUE + 1L
        assertEquals(expectedNumber, actual)
    }

    @Test
    fun test_sum_int(){
        val numbers: Numbers = Numbers.Base(2_000_000_000, 147483647)
        val isSumLong = numbers.isSumLong()
        val expected = false
        assertEquals(expected, isSumLong)
        val actual: Int = numbers.sumInt()
        val expectedNumber: Int = Int.MAX_VALUE
        assertEquals(expectedNumber, actual)
    }

    @Test(expected = IllegalAccessException::class)
    fun test_sum_int_no_check() {
        val numbers: Numbers = Numbers.Base(2_000_000_000,2_000_000_000)
        numbers.sumInt()
    }

    @Test(expected = IllegalAccessException::class)
    fun test_sum_long_no_check() {
        val numbers: Numbers = Numbers.Base(2_000_000_000,2_000_000_000)
        numbers.sumLong()
    }

    @Test(expected = IllegalStateException::class)
    fun test_sum_long_called_for_long_sum(){
        val numbers: Numbers = Numbers.Base(2_000_000_000,2_000_000_000)
        val actual = numbers.isSumLong()
        val excepted = true
        assertEquals(excepted, actual)
        numbers.sumInt()
    }

    @Test(expected = IllegalStateException::class)
    fun test_sum_long_called_for_int_sum(){
        val numbers: Numbers = Numbers.Base(2_000_000_000,1_000_000)
        val actual = numbers.isSumLong()
        val excepted = false
        assertEquals(excepted, actual)
        numbers.sumLong()
    }

    @Test
    fun test_difference(){
        val numbers: Numbers = Numbers.Base(12, 4)
        val actual = numbers.difference()
        val expected = 8
        assertEquals(expected, actual)
    }

    @Test
    fun test_divide(){
        val numbers: Numbers = Numbers.Base(12, 4)
        val actual = numbers.divide()
        val expected = 3.0
        assertEquals(expected, actual, 0.000000000000001)
    }

    @Test
    fun test_divide_double(){
        val numbers: Numbers = Numbers.Base(10, 4)
        val actual = numbers.divide()
        val expected = 2.5
        assertEquals(expected, actual, 0.000000000000001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_divide_zero(){
        val numbers: Numbers = Numbers.Base(3, 0)
        numbers.divide()
    }
}