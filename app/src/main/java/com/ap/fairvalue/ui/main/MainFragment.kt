package com.ap.fairvalue.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ap.fairvalue.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        requireActivity().title = getString(R.string.app_name)

        btnDcf.setOnClickListener { viewModel.onDcfClick() }
        btnDdm.setOnClickListener { viewModel.onDdmClick() }
        btnBgf.setOnClickListener { viewModel.onBgfClick() }
        btnDcfDescription.setOnClickListener { viewModel.onDcfDescriptionClick() }
        btnDdmDescription.setOnClickListener { viewModel.onDdmDescriptionClick() }
        btnBgfDescription.setOnClickListener { viewModel.onBgfDescriptionClick() }

        viewModel.needShowDcf.observe(this, Observer { value ->
            observerNavigation(value, viewModel.needShowDcf, R.id.action_mainFragment_to_dcfFragment)
        })

        viewModel.needShowBgf.observe(this, Observer { value ->
            observerNavigation(value, viewModel.needShowBgf, R.id.action_mainFragment_to_bfgFragment)
        })

        viewModel.needShowDdm.observe(this, Observer { value ->
            observerNavigation(value, viewModel.needShowDdm, R.id.action_mainFragment_to_ddmFragment)
        })

        viewModel.needShowDcfDescription.observe(this, Observer { value ->
            observerNavigationDescription(
                value,
                viewModel.needShowDcfDescription,
                R.string.dcfDescription
            )
        })

        viewModel.needShowBgfDescription.observe(this, Observer { value ->
            observerNavigationDescription(
                value,
                viewModel.needShowBgfDescription,
                R.string.bfgDescription
            )
        })

        viewModel.needShowDdmDescription.observe(this, Observer { value ->
            observerNavigationDescription(
                value,
                viewModel.needShowDdmDescription,
                R.string.ddmDescription
            )
        })
    }

    private fun observerNavigation(value: Boolean, liveBoolean: MutableLiveData<Boolean>, actionId: Int) {
        if (value) {
            view?.let { Navigation.findNavController(view!!).navigate(actionId) }
            liveBoolean.value = false
        }
    }

    private fun observerNavigationDescription(value: Boolean, liveBoolean: MutableLiveData<Boolean>, idString: Int) {
        if (value) {
            view?.let {
                Navigation.findNavController(view!!)
                    .navigate(
                        R.id.action_mainFragment_to_descriptionFragment,
                        bundleOf("idDescriptionString" to idString)
                    )
            }
            liveBoolean.value = false
        }
    }
}
