package com.ap.fairvalue.ui.ddm

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ap.fairvalue.model.FairValueModel

class DdmViewModel : ViewModel() {

    val dividendPerShareString = ObservableField<String>("2.43")
    val growthRate5 = ObservableInt(4)
    val growthRate10 = ObservableInt(4)
    val growthRate11 = ObservableInt(1)
    val discountRate = ObservableInt(5)
    val fairValue = ObservableInt(79)
    val needKeyboardHide = MutableLiveData<Boolean>(false)

    fun clearDividendPerShare() {
        dividendPerShareString.set(null)
    }

    fun calc() {
        if (dividendPerShareString.get()?.isNotEmpty()!!) {
            fairValue.set(
                FairValueModel.calcDdm(
                    dividendPerShareString.get()!!.toDouble(),
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

    fun onDdmGrowthRate5ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDdmGrowthRate10ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDdmGrowthRate11ValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

    fun onDdmDiscountRateValueChanged(fromUser: Boolean) {
        if (fromUser) {
            needKeyboardHide.value = true
        }
    }

}
