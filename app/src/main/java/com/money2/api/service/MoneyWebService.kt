package com.money2.api.service

import android.util.Log
import com.money2.api.entities.MoneyDtos
import com.money2.api.inicializator.InicializatorRetrofit
import com.money2.util.convertToScale

private const val TAG = "MoneyWebService"

class MoneyWebService {
    private val moneyApiService: MoneyApi =
        InicializatorRetrofit().moneyApi

    suspend fun convertMoney(country_to: String, country_from: String, money: Double): String? {
        var returnV: String? = null
        try {
            val convertMoneyReturn = moneyApiService
                .convertMoney(country_to, country_from, money)
            returnV = convertToScale(convertMoneyReturn.result)
            Log.i("resultConvertMoney", "convertMoney:result=${convertMoneyReturn.result} | $returnV")
        } catch (e: Exception) {
            Log.e(TAG, "moneyApiService: ", e)
        }
        return returnV
    }
}