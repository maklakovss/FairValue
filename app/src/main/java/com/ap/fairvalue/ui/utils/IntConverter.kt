package com.ap.fairvalue.ui.utils

import androidx.databinding.InverseMethod

object IntConverter {

    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToInt(value: String): Int {
        if (value.isEmpty()) {
            return 0
        }

        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }
}