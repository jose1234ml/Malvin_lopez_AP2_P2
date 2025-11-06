package com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.viewmodel.GastoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastoCreateScreen(
    modifier: Modifier = Modifier,
    viewModel: GastoViewModel = hiltViewModel()
) {
    var suplidor by remember { mutableStateOf("") }
    var ncf by remember { mutableStateOf("") }
    var itbis by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Nuevo Gasto") }) }
    ) { padding ->
        Column(
            modifier = modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(value = suplidor, onValueChange = { suplidor = it }, label = { Text("Suplidor") })
            OutlinedTextField(value = ncf, onValueChange = { ncf = it }, label = { Text("NCF") })
            OutlinedTextField(value = itbis, onValueChange = { itbis = it }, label = { Text("ITBIS") })
            OutlinedTextField(value = monto, onValueChange = { monto = it }, label = { Text("Monto") })

            Button(
                onClick = {
                    viewModel.agregarGasto(
                        Gasto(
                            0,
                            "2025-11-05T00:00:00",
                            suplidor,
                            ncf,
                            itbis.toDoubleOrNull() ?: 0.0,
                            monto.toDoubleOrNull() ?: 0.0,
                            fecha = TODO()
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}