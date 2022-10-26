package com.money2.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.money2.data.MoneyDtos
import com.money2.respository.MoneyRepository
import kotlinx.coroutines.launch

class MoneyViewModel: ViewModel() {

    private val repository = MoneyRepository()
    private var moneyResult = MutableLiveData<MoneyDtos.Money>()

    fun convertMoney(country_to: String, country_from: String, money: Double) {
        viewModelScope.launch {
            moneyResult.value=repository.convertMoney(country_to, country_from, money)
        }
    }

    fun getConvertMoney(): MoneyDtos.Money {
        return moneyResult.value?: MoneyDtos.Money("Api Error")
    }
}