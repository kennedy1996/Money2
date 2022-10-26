package com.money2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.os.Looper
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.money2.R
import com.money2.ui.viewModel.MoneyViewModel

class MoneyActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val provider = ViewModelProvider(this)
        provider[MoneyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.money_activity)
        settingsButton()
    }

    private fun settingsButton() {
        val money = findViewById<EditText>(R.id.money_activity_insert_money_field)
        val resultField = findViewById<TextView>(R.id.money_activity_result)
        val buttonFromDolarToEuro = findViewById<Button>(R.id.money_activity_button_from_dolar)
        val buttonFromEuroToDolar = findViewById<Button>(R.id.money_activity_button_from_euro)
        val progressBar = findViewById<ProgressBar>(R.id.money_activity_progressBar)

        buttonFromDolarToEuro.setOnClickListener {
            onClickConvert(money, progressBar, resultField, "USD", "EUR")
        }
        buttonFromEuroToDolar.setOnClickListener {
            onClickConvert(money, progressBar, resultField, "EUR", "USD")
        }
    }

    private fun onClickConvert(
        money: EditText,
        progressBar: ProgressBar,
        resultField: TextView,
        country_to: String,
        country_from: String
    ) {
        val moneyText = money.text.toString()
        if (!moneyText.isNullOrBlank()) {
            viewModel.convertMoney(country_to, country_from, moneyText.toDouble())
            progressBar.visibility = View.VISIBLE
            runAfterTime(progressBar, resultField, country_to, country_from)
        } else money.error = "Invalid Money"
    }

    private fun runAfterTime(
        progressBar: ProgressBar,
        resultField: TextView,
        country_to: String,
        country_from: String
    ) {
        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.GONE
            val moneyConverted = viewModel.getConvertMoney().moneyConverted
            val moneyUnity = viewModel.getConvertMoney().moneyUnity
            val moneyToConvert = viewModel.getConvertMoney().moneyToConvert

            val textMoneyUnity = "$country_from 1\n=\n$country_to $moneyUnity"
            val textMoneyConverted = "$country_from $moneyToConvert\n=\n$country_to $moneyConverted"


            resultField.text = "$textMoneyUnity\n\n$textMoneyConverted"
        }, 3000)
    }
}