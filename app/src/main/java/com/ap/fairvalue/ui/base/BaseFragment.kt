package com.ap.fairvalue.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        (requireActivity() as AppCompatActivity).apply { supportActionBar?.setDisplayHomeAsUpEnabled(true) }
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).apply {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }
}