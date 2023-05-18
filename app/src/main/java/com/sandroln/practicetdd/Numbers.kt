package com.sandroln.practicetdd

interface Numbers {

    fun sum(): Int

    fun difference(): Int

    class Base(
        private val first: Int,
        private val second: Int
    ) : Numbers {

        override fun sum(): Int {
            return first + second
        }

        override fun difference(): Int {
            return first - second
        }

    }

}