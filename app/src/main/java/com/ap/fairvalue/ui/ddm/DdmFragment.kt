package com.ap.fairvalue.ui.ddm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import com.ap.fairvalue.databinding.DdmFragmentBinding
import com.ap.fairvalue.ui.base.BaseFragment


class DdmFragment : BaseFragment() {

    private lateinit var viewModel: DdmViewModel
    private lateinit var binding: DdmFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.ddm_fragment, container, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DdmViewModel::class.java)
        binding.model = viewModel
    }

}
