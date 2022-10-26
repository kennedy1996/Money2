package com.money2.api.entities

class MoneyApiDtos {
    class Convert(
        val sucess: Boolean,
        val query: Queri,
        val info: Info,
        val result: Double
    )

    class Info(
        val quote: Double
    )

    class Queri(
        val from: String,
        val to: String,
        val amount: Double
    )
}