package com.ap.fairvalue.ui.dcf

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ap.fairvalue.R


class DcfFragment : Fragment() {

    companion object {
        fun newInstance() = DcfFragment()
    }

    private lateinit var viewModel: DcfViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dcf_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DcfViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
