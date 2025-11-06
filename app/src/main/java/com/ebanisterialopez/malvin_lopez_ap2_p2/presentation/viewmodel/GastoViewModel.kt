package com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase.CreateGastoUseCase
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase.GetGastoUseCase
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase.UpdateGastoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GastoViewModel @Inject constructor(
    private val getGastos: GetGastoUseCase,
    private val createGasto: CreateGastoUseCase,
    private val updateGasto: UpdateGastoUseCase,
) : ViewModel() {

    private val _gastos = MutableStateFlow<List<Gasto>>(emptyList())
    val gastos: StateFlow<List<Gasto>> = _gastos

    fun cargarGastos() {
        viewModelScope.launch {
            _gastos.value = getGastos()
        }
    }

    fun agregarGasto(gasto: Gasto) {
        viewModelScope.launch {
            createGasto(gasto)
            cargarGastos()
        }
    }

    fun modificarGasto(gasto: Gasto) {
        viewModelScope.launch {
            updateGasto(gasto)
            cargarGastos()
        }
    }


}