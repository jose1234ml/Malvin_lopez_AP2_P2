package com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model

data class Gasto(
    val gastoId: Int? = 0,
    val gasto: String,
    val suplidor: String,
    val ncf: String,
    val itbis: Double,
    val monto: Double,
    val fecha: String
)
