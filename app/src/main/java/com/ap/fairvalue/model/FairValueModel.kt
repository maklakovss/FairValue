package com.ap.fairvalue.model

import kotlin.math.pow
import kotlin.math.roundToInt

object FairValueModel {

    fun calcDcf(
        earningPerShare: Double,
        growthRate5: Double,
        growthRate10: Double,
        growthRate11: Double,
        discountRate: Double
    ): Int {
        var eps = earningPerShare
        var growth = growthRate5
        var value: Double
        var pv = 0.0

        for (i in 1..10) {
            if (i == 6) {
                growth = growthRate10
            }
            eps *= (growth + 1)
            value = eps / ((1 + discountRate).pow(i.toDouble()))
            pv += value
        }
        val terminalYear = eps * (growthRate11 + 1)
        val terminalValue = (terminalYear / (discountRate - growthRate11)) / (1 + discountRate).pow(10.0)

        return (terminalValue + pv).roundToInt()
    }

    fun calcDdm(
        dividentPerShare: Double,
        growthRate5: Double,
        growthRate10: Double,
        growthRate11: Double,
        discountRate: Double
    ): Int {
        var eps = dividentPerShare
        var growth = growthRate5
        var value: Double
        var pv = 0.0

        for (i in 1..10) {
            if (i == 6) {
                growth = growthRate10
            }
            eps *= (growth + 1)
            value = eps / ((1 + discountRate).pow(i.toDouble()))
            pv += value
        }
        val terminalYear = eps * (growthRate11 + 1)
        val terminalValue = (terminalYear / (discountRate - growthRate11)) / (1 + discountRate).pow(10.0)

        return (terminalValue + pv).roundToInt()
    }

    fun calcBcf(earlingPerShare: Double, growthRate: Double): Int {
        return (earlingPerShare * (8.5 + 2.0 * growthRate)).roundToInt()
    }
}