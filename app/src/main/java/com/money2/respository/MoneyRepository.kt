package com.money2.respository

import com.money2.api.service.MoneyWebService
import com.money2.data.MoneyDtos

class MoneyRepository {
    private val webClient = MoneyWebService()

    suspend fun convertMoney(country_to: String, country_from: String, money: Double): MoneyDtos.Money? {
        return webClient.convertMoney(country_to, country_from, money)
    }
}