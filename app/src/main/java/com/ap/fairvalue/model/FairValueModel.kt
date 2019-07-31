package com.ap.fairvalue.model

object FairValueModel {

    fun calcDcf(
        earningPerShare: Double,
        growthRate5: Double,
        growthRate10: Double,
        growthRate11: Double,
        discountRate: Double
    ): Double {
        var eps = earningPerShare
        var growth = growthRate5
        var value = 0.0
        var pv = 0.0

        for (i in 1..10) {
            if (i == 6) {
                growth = growthRate10
            }
            eps = eps * (growth + 1)
            value = eps / (Math.pow(1 + discountRate, i.toDouble()))
            pv += value
        }
        var terminalYear = eps * (growthRate11 + 1)
        var terminalValue = (terminalYear / (discountRate - growthRate11)) / Math.pow(1 + discountRate, 10.0)

        return terminalValue
    }

}