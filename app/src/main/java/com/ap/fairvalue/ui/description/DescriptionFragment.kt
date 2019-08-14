package com.ap.fairvalue.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import com.ap.fairvalue.ui.base.BaseFragment
import kotlinx.android.synthetic.main.description_fragment.*


class DescriptionFragment : BaseFragment() {

    private lateinit var viewModel: DescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DescriptionViewModel::class.java)
        val id = arguments!!.getInt("idDescriptionString", 0)
        arguments?.let { tvDescription.text = getString(id) }
        requireActivity().title = getString(
            when (id) {
                R.string.ddmDescription -> R.string.ddm
                R.string.dcfDescription -> R.string.dcf
                R.string.bfgDescription -> R.string.bfg
                else -> R.string.app_name
            }
        )
    }
}
