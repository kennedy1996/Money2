package com.money2.respository

import com.money2.api.service.MoneyWebService

class MoneyRepository {
    private val webClient = MoneyWebService()

    suspend fun convertMoney(contry_to: String, country_from: String, money: Double) {
        return webClient.convertMoney(contry_to, country_from, money)
    }
}