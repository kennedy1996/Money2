package com.money2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.os.Looper
import android.util.Log
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

        val money = findViewById<EditText>(R.id.money_activity_insert_money_field)
        val resultField = findViewById<TextView>(R.id.money_activity_result)
        val buttonFromDolarToEuro = findViewById<Button>(R.id.money_activity_button_from_dolar)
        val buttonFromEuroToDolar = findViewById<Button>(R.id.money_activity_button_from_euro)
        val progressBar = findViewById<ProgressBar>(R.id.money_activity_progressBar)

        buttonFromDolarToEuro.setOnClickListener {
            val moneyText = money.text.toString()
            if (!moneyText.isNullOrBlank()) {
                viewModel.convertMoney("USD", "EUR", moneyText.toDouble())
                progressBar.visibility = View.VISIBLE
                Handler(Looper.getMainLooper()).postDelayed({
                    progressBar.visibility = View.GONE
                    resultField.text = viewModel.getConvertMoney()
                }, 3000)
            } else money.error = "Invalid Money"
        }
    }
}