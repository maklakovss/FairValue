package com.ap.fairvalue.ui.utils

import androidx.databinding.InverseMethod

object DoubleConverter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String {
        if (value.isNaN()) {
            return ""
        } else {
            return value.toString()
        }
    }

    @JvmStatic
    fun stringToDouble(value: String): Double {
        if (value.isEmpty()) {
            return 0.0
        }

        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }
}