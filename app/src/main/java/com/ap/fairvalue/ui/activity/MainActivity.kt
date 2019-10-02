package com.ap.fairvalue.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.ap.fairvalue.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.main_activity.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var interstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initAdMob()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    fun initAdMob() {
        MobileAds.initialize(this, getString(R.string.AdsAppId))

        val adRequest = AdRequest.Builder()
//            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build()
        adView.loadAd(adRequest)

        interstitialAd = InterstitialAd(applicationContext)
        interstitialAd?.setAdListener(object : AdListener() {
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
                if (interstitialAd != null) {
                    if (interstitialAd?.isLoaded() ?: false) {
                        interstitialAd?.show()
                    }
                }
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Timber.d("onAdClicked")
            }
        })
        interstitialAd?.setAdUnitId(getString(R.string.AdsPageId))
        interstitialAd?.loadAd(AdRequest.Builder().build())
    }

    override fun onDestroy() {
        interstitialAd?.adListener = null
        interstitialAd = null
        super.onDestroy()
    }
}
