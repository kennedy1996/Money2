package com.money2.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.money2.respository.MoneyRepository
import kotlinx.coroutines.launch

class MoneyViewModel: ViewModel() {

    private val repository = MoneyRepository()

    fun convertMoney(contry_to: String, country_from: String, money: Double) {
        viewModelScope.launch {

        }
    }

    fun getConvertMoney() {

    }
}