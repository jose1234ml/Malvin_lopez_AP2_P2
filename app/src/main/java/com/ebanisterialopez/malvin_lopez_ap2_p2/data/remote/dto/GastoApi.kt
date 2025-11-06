package com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.api

import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.dto.GastoDto
import retrofit2.Response
import retrofit2.http.*

interface GastoApi {

    @GET("Gastos")
    suspend fun getGastos(): List<GastoDto>

    @POST("Gastos")
    suspend fun createGasto(@Body gasto: GastoDto): Response<Unit>

    @PUT("Gastos/{id}")
    suspend fun updateGasto(@Path("id") id: Int?, @Body gasto: GastoDto): Response<Unit>

}