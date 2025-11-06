package com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase

import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.repository.GastoRepository

class CreateGastoUseCase(private val repository: GastoRepository) {
    suspend operator fun invoke(gasto: Gasto) = repository.createGasto(gasto)
}