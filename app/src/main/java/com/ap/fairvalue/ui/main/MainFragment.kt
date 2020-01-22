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
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.main_fragment.*
import timber.log.Timber

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var interstitialAd: InterstitialAd? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
            observerNavigation(
                value,
                viewModel.needShowDcf,
                R.id.action_mainFragment_to_dcfFragment
            )
        })

        viewModel.needShowBgf.observe(this, Observer { value ->
            observerNavigation(
                value,
                viewModel.needShowBgf,
                R.id.action_mainFragment_to_bfgFragment
            )
        })

        viewModel.needShowDdm.observe(this, Observer { value ->
            observerNavigation(
                value,
                viewModel.needShowDdm,
                R.id.action_mainFragment_to_ddmFragment
            )
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

        viewModel.needShowInterstitialAd.observe(this, Observer { showInterstitialAd() })

        initInterstitialAd()
    }

    private fun initInterstitialAd() {
        interstitialAd = InterstitialAd(requireActivity())
        interstitialAd?.adListener = object : AdListener() {
            override fun onAdClosed() {
                super.onAdClosed()
                Timber.d("onAdClosed")
            }

            override fun onAdFailedToLoad(i: Int) {
                super.onAdFailedToLoad(i)
                Timber.d("onAdFailedToLoad %d", i)
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Timber.d("onAdLoaded")
                showInterstitialAd()
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Timber.d("onAdClicked")
            }
        }
        interstitialAd?.adUnitId = getString(R.string.AdsPageId)
        interstitialAd?.loadAd(AdRequest.Builder().build())


    }

    private fun showInterstitialAd() {
        interstitialAd?.let {
            if (it.isLoaded() && viewModel.needShowInterstitialAd.value ?: false) {
                viewModel.needShowInterstitialAd.value = false
                it.show()
            }
        }
    }

    override fun onDestroy() {
        interstitialAd?.adListener = null
        interstitialAd = null
        super.onDestroy()
    }

    private fun observerNavigation(
        value: Boolean,
        liveBoolean: MutableLiveData<Boolean>,
        actionId: Int
    ) {
        if (value) {
            view?.let { Navigation.findNavController(view!!).navigate(actionId) }
            liveBoolean.value = false
        }
    }

    private fun observerNavigationDescription(
        value: Boolean,
        liveBoolean: MutableLiveData<Boolean>,
        idString: Int
    ) {
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
