package com.ap.fairvalue.ui.bfg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import com.ap.fairvalue.databinding.BfgFragmentBinding
import com.ap.fairvalue.ui.base.BaseFragment
import com.ap.fairvalue.ui.utils.KeyboardUtil


class BfgFragment : BaseFragment() {

    private lateinit var viewModel: BfgViewModel
    private lateinit var binding: BfgFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.bfg_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BfgViewModel::class.java)
        binding.model = viewModel
        viewModel.needKeyboardHide.observe(this, Observer { value ->
            if (value) {
                viewModel.needKeyboardHide.value = false
                KeyboardUtil.hideKeyboard(requireView())
            }
        })
        requireActivity().title = getString(R.string.bfg)
    }

}
