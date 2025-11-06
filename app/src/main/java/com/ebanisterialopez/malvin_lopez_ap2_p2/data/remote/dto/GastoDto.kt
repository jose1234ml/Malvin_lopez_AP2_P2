package com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.dto

import com.squareup.moshi.Json

data class GastoDto(
    val gastoId: Int? = null,
    val gasto: String,
    val suplidor: String,
    val ncf: String,
    val itbis: Double,
    val monto: Double,
    val fecha: String
)