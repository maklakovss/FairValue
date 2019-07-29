package com.ap.fairvalue.ui.bfg

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ap.fairvalue.R


class BfgFragment : Fragment() {

    companion object {
        fun newInstance() = BfgFragment()
    }

    private lateinit var viewModel: BfgViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bfg_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BfgViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
