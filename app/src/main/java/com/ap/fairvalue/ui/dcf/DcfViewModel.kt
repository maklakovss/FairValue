package com.ap.fairvalue.ui.dcf

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ap.fairvalue.model.FairValueModel

class DcfViewModel : ViewModel() {

    val earningPerShareString = ObservableField<String>("2.43")
    val growthRate5 = ObservableInt(4)
    val growthRate10 = ObservableInt(4)
    val growthRate11 = ObservableInt(1)
    val discountRate = ObservableInt(5)
    val fairValue = ObservableInt(79)
    val needKeyboardHide = MutableLiveData<Boolean>(false)

    fun calc() {
        if (earningPerShareString.get()?.isNotEmpty()!!) {
            fairValue.set(
                FairValueModel.calcDcf(
                    earningPerShareString.get()!!.toDouble(),
                    growthRate5.get() / 100.0,
                    growthRate10.get() / 100.0,
                    growthRate11.get() / 100.0,
                    discountRate.get() / 100.0
                )
            )
        } else {
            fairValue.set(0)
        }
    }

    fun onDcfGrowthRate5ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDcfGrowthRate10ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDcfGrowthRate11ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDcfDiscountRateValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

}
