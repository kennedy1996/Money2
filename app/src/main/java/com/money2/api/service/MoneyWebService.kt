package com.money2.api.service

import android.util.Log
import com.money2.api.inicializator.InicializatorRetrofit
import com.money2.data.MoneyDtos
import com.money2.util.convertToScale

private const val TAG = "MoneyWebService"

class MoneyWebService {
    private val moneyApiService: MoneyApi =
        InicializatorRetrofit().moneyApi

    suspend fun convertMoney(
        country_to: String,
        country_from: String,
        money: Double
    ): MoneyDtos.Money? {
        var returnV: MoneyDtos.Money? = null
        try {
            val convertMoneyReturn = moneyApiService
                .convertMoney(country_to, country_from, money)
            returnV = MoneyDtos.Money(
                convertToScale(convertMoneyReturn.result),
                convertMoneyReturn.info.quote,
                convertMoneyReturn.query.amount
            )
        } catch (e: Exception) {
            Log.e(TAG, "moneyApiService: ", e)
        }
        return returnV
    }
}