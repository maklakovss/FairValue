package com.ap.fairvalue.ui.ddm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ap.fairvalue.R


class DdmFragment : Fragment() {

    companion object {
        fun newInstance() = DdmFragment()
    }

    private lateinit var viewModel: DdmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ddm_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DdmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
