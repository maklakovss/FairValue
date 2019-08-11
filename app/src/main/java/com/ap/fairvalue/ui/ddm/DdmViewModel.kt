package com.ap.fairvalue.ui.ddm

import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel;
import com.ap.fairvalue.model.FairValueModel

class DdmViewModel : ViewModel() {
    val dividentPerShare = ObservableDouble(2.43)
    val growthRate5 = ObservableDouble(4.0)
    val growthRate10 = ObservableDouble(4.0)
    val growthRate11 = ObservableDouble(1.0)
    val discountRate = ObservableDouble(5.0)
    val fairValue = ObservableInt(79)

    fun calc() {
        fairValue.set(
            FairValueModel.calcDdm(
                dividentPerShare.get(),
                growthRate5.get() / 100,
                growthRate10.get() / 100,
                growthRate11.get() / 100,
                discountRate.get() / 100
            )
        )
    }
}
