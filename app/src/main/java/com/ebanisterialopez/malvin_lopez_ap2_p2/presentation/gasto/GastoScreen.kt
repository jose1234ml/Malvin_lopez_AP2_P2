package com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.viewmodel.GastoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastoScreen(
    modifier: Modifier = Modifier,
    viewModel: GastoViewModel = hiltViewModel()
) {
    val gastos by viewModel.gastos.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.cargarGastos()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Gastos") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gastos) { gasto ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Suplidor: ${gasto.suplidor}")
                        Text("NCF: ${gasto.ncf}")
                        Text("Monto: ${gasto.monto}")
                        Text("Fecha: ${gasto.fecha}")

                        }
                    }
                }
            }
        }
    }
