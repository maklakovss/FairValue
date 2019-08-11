package com.ap.fairvalue.ui.bfg

import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel;
import com.ap.fairvalue.model.FairValueModel

class BfgViewModel : ViewModel() {
    val earlingPerShare = ObservableDouble(2.43)
    val growthRate = ObservableDouble(5.0)
    val fairValue = ObservableInt(45)

    fun calc() {
        fairValue.set(FairValueModel.calcBcf(earlingPerShare.get(), growthRate.get()))
    }
}
