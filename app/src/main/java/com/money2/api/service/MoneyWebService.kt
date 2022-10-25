package com.money2.api.service

import android.util.Log
import com.money2.api.entities.MoneyDtos
import com.money2.api.inicializator.InicializatorRetrofit

private const val TAG = "MoneyWebService"

class MoneyWebService {
    private val moneyApiService: MoneyApi =
        InicializatorRetrofit().moneyApi

    suspend fun convertMoney(country_to: String, country_from: String, money: Double) {
        var returnV: MoneyDtos.Money? = null
        try {
            val convertMoneyReturn = moneyApiService
                .convertMoney(country_to, country_from, money)
//        returnV = MoneyDtos.Money(convertToScale(convertMoneyReturn.result))
            Log.i("resultConvertMoney", "convertMoney:result=${convertMoneyReturn.result}")
        } catch (e: Exception) {
            Log.e(TAG, "moneyApiService: ", e)
        }
    }
}