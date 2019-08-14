package com.ap.fairvalue.ui.dcf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import com.ap.fairvalue.databinding.DcfFragmentBinding
import com.ap.fairvalue.ui.base.BaseFragment


class DcfFragment : BaseFragment() {

    private lateinit var viewModel: DcfViewModel
    private lateinit var binding: DcfFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dcf_fragment, container, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DcfViewModel::class.java)
        binding.model = viewModel
        requireActivity().title = getString(R.string.dcf)
    }

}
