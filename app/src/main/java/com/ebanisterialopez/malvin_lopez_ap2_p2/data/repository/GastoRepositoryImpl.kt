package com.ebanisterialopez.malvin_lopez_ap2_p2.data.repository

import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.api.GastoApi
import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.mapper.toDomain
import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.mapper.toDto
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.repository.GastoRepository

class GastoRepositoryImpl(
    private val api: GastoApi
) : GastoRepository {

    override suspend fun getGastos(): List<Gasto> =
        api.getGastos().map { it.toDomain() }

    override suspend fun createGasto(gasto: Gasto): List<Gasto> {
        api.createGasto(gasto.toDto())

        return api.getGastos().map { it.toDomain() }
    }

    override suspend fun updateGasto(gasto: Gasto): List<String> {
        api.updateGasto(gasto.gastoId, gasto.toDto())

        return listOf("Gasto actualizado correctamente")
    }

}