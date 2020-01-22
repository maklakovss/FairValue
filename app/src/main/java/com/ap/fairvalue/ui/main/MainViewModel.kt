package com.ap.fairvalue.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var hasShowInterstitialAd = false;

    var needShowDdm = MutableLiveData<Boolean>().apply { value = false }
    var needShowDcf = MutableLiveData<Boolean>().apply { value = false }
    var needShowBgf = MutableLiveData<Boolean>().apply { value = false }
    var needShowDdmDescription = MutableLiveData<Boolean>().apply { value = false }
    var needShowDcfDescription = MutableLiveData<Boolean>().apply { value = false }
    var needShowBgfDescription = MutableLiveData<Boolean>().apply { value = false }
    var needShowInterstitialAd = MutableLiveData<Boolean>().apply { value = false }

    fun onDcfClick() {
        needShowDcf.value = true
        showInterstitialAd()
    }

    fun onDdmClick() {
        needShowDdm.value = true
    }

    fun onBgfClick() {
        needShowBgf.value = true
    }

    fun onDdmDescriptionClick() {
        needShowDdmDescription.value = true
    }

    fun onBgfDescriptionClick() {
        needShowBgfDescription.value = true
    }

    fun onDcfDescriptionClick() {
        needShowDcfDescription.value = true
        showInterstitialAd()
    }

    private fun showInterstitialAd() {
        if (!hasShowInterstitialAd) {
            hasShowInterstitialAd = true
            needShowInterstitialAd.value = true
        }
    }
}
