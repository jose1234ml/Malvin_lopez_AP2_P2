package com.ebanisterialopez.malvin_lopez_ap2_p2.domain.repository

import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto

interface GastoRepository{
    suspend fun getGastos(): List<Gasto>
    suspend fun createGasto(gasto: Gasto): List<Gasto>
    suspend fun  updateGasto(gasto: Gasto): List<String>
}