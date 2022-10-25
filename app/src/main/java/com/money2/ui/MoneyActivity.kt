package com.money2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        viewModel.convertMoney("EUR", "USD", 100.0)



    }
}