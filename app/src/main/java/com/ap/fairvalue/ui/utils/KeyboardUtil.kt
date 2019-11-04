package com.ap.fairvalue.ui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


class KeyboardUtil {
    companion object {
        fun hideKeyboard(view: View) {
            view.clearFocus()
            val imm =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}