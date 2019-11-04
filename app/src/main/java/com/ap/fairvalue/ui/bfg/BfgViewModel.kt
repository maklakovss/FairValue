package com.ap.fairvalue.ui.bfg

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ap.fairvalue.model.FairValueModel

class BfgViewModel : ViewModel() {

    val earningPerShareString = ObservableField<String>("2.43")
    val growthRate = ObservableInt(5)
    val fairValue = ObservableInt(45)
    val needKeyboardHide = MutableLiveData<Boolean>(false)

    fun calc() {
        needKeyboardHide.value = true
        if (earningPerShareString.get()?.isNotEmpty()!!) {
            fairValue.set(
                FairValueModel.calcBcf(
                    earningPerShareString.get()!!.toDouble(),
                    growthRate.get()
                )
            )
        } else {
            fairValue.set(0)
        }
    }

    fun onBfgGrowthRateValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

}
