package com.ap.fairvalue.ui.ddm

import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel;
import com.ap.fairvalue.model.FairValueModel

class DdmViewModel : ViewModel() {
    val dividendPerShare = ObservableDouble(2.43)
    val growthRate5 = ObservableInt(4)
    val growthRate10 = ObservableInt(4)
    val growthRate11 = ObservableInt(1)
    val discountRate = ObservableInt(5)
    val fairValue = ObservableInt(79)

    fun calc() {
        fairValue.set(
            FairValueModel.calcDdm(
                dividendPerShare.get(),
                growthRate5.get() / 100.0,
                growthRate10.get() / 100.0,
                growthRate11.get() / 100.0,
                discountRate.get() / 100.0
            )
        )
    }
}
