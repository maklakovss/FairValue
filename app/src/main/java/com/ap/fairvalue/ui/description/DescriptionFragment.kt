package com.ap.fairvalue.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import kotlinx.android.synthetic.main.description_fragment.*


class DescriptionFragment : Fragment() {

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
        arguments?.let { tvDescription.text = getString(arguments!!.getInt("idDescriptionString", 0)) }
    }
}
