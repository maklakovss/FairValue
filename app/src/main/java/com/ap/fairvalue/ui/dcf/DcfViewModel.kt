package com.ap.fairvalue.ui.dcf

import androidx.databinding.ObservableDouble
import androidx.lifecycle.ViewModel
import com.ap.fairvalue.model.FairValueModel

class DcfViewModel : ViewModel() {

    val earningPerShare = ObservableDouble(2.43)
    val growthRate5 = ObservableDouble(4.0)
    val growthRate10 = ObservableDouble(4.0)
    val growthRate11 = ObservableDouble(1.0)
    val discountRate = ObservableDouble(5.0)
    val fairValue = ObservableDouble(0.0)

    fun calc() {
        fairValue.set(
            FairValueModel.calcDcf(
                earningPerShare.get(),
                growthRate5.get() / 100,
                growthRate10.get() / 100,
                growthRate11.get() / 100,
                discountRate.get() / 100
            )
        )
    }
}
