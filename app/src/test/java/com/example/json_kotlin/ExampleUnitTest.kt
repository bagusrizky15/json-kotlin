package com.example.json_kotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun multiply_test(){
        val a = 10
        val b = 2
        val expectedResult = 20
        assertEquals(expectedResult, multiply(a,b))
    }

    fun multiply(a: Int, b: Int) = a * b
}