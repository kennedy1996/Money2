package com.money2.respository

import com.money2.api.service.MoneyWebService

class MoneyRepository {
    private val webClient = MoneyWebService()

    suspend fun convertMoney(country_to: String, country_from: String, money: Double): String? {
        return webClient.convertMoney(country_to, country_from, money)
    }
}