package com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase

import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.repository.GastoRepository

class GetGastoUseCase(private val repository: GastoRepository) {
    suspend operator fun invoke() = repository.getGastos()
}