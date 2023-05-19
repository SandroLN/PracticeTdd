package com.sandroln.practicetdd

interface Numbers {

    fun difference(): Int

    fun divide(): Double

    fun isSumLong(): Boolean

    fun sumLong(): Long

    fun sumInt(): Int

    class Base(
        private val first: Int,
        private val second: Int
    ) : Numbers {

        private var wasSumLongCalled = false
        private var wasSumLong = false

        override fun isSumLong(): Boolean {
            wasSumLongCalled = true
            val rest = Int.MAX_VALUE - first
            val result = second > rest
            wasSumLong = result
            return second > rest
        }

        override fun sumLong(): Long {
            if (wasSumLongCalled) {
                if (wasSumLong)
                    return first.toLong() + second
                throw IllegalStateException("you shouldn't use this method: sumLong")
            }
            throw IllegalAccessException("first you should check the sum by method isSumLong")
        }

        override fun sumInt(): Int {
            if (wasSumLongCalled) {
                if (wasSumLong)
                    throw IllegalStateException("you shouldn't use this method: sumInt")
                return first + second
            }
            throw IllegalAccessException("first you should check the sum by method isSumLong")
        }

        override fun difference(): Int {
            return first - second
        }

        override fun divide(): Double {
            if (second == 0)
                throw IllegalArgumentException()
            return first.toDouble() / second
        }

    }

}