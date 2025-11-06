package com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.mapper

import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.dto.GastoDto
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import java.time.format.DateTimeFormatter

fun GastoDto.toDomain(): Gasto = Gasto(
    gastoId = gastoId,
    gasto = gasto,
    fecha = fecha,
    suplidor = suplidor,
    ncf = ncf,
    itbis = itbis,
    monto = monto
)



fun Gasto.toDto(): GastoDto {
    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    return GastoDto(
        gastoId = this.gastoId,
        gasto = this.gasto,
        suplidor = this.suplidor,
        ncf = this.ncf,
        itbis = this.itbis,
        monto = this.monto,
        fecha = this.fecha.format(formatter)
    )
}