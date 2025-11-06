package com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.model.Gasto
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.viewmodel.GastoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastoEditScreen(
    modifier: Modifier = Modifier,
    viewModel: GastoViewModel = hiltViewModel()
) {
    val gastos by viewModel.gastos.collectAsState()
    var selectedId by remember { mutableStateOf<Int?>(null) }

    val gasto = gastos.find { it.gastoId == selectedId }

    var suplidor by remember { mutableStateOf(gasto?.suplidor ?: "") }
    var ncf by remember { mutableStateOf(gasto?.ncf ?: "") }
    var itbis by remember { mutableStateOf(gasto?.itbis?.toString() ?: "") }
    var monto by remember { mutableStateOf(gasto?.monto?.toString() ?: "") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Editar Gasto") }) }
    ) { padding ->
        Column(
            modifier = modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DropdownMenuDemo(gastos) { selectedId = it }

            if (selectedId != null) {
                OutlinedTextField(value = suplidor, onValueChange = { suplidor = it }, label = { Text("Suplidor") })
                OutlinedTextField(value = ncf, onValueChange = { ncf = it }, label = { Text("NCF") })
                OutlinedTextField(value = itbis, onValueChange = { itbis = it }, label = { Text("ITBIS") })
                OutlinedTextField(value = monto, onValueChange = { monto = it }, label = { Text("Monto") })

                Button(
                    onClick = {
                        viewModel.modificarGasto(
                            gasto!!.copy(
                                suplidor = suplidor,
                                ncf = ncf,
                                itbis = itbis.toDoubleOrNull() ?: 0.0,
                                monto = monto.toDoubleOrNull() ?: 0.0
                            )
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Guardar Cambios")
                }
            }
        }
    }
}

@Composable
fun DropdownMenuDemo(gastos: List<Gasto>, onSelect: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Seleccionar gasto") }

    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            label = { Text("Selecciona un gasto") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            gastos.forEach { gasto ->
                DropdownMenuItem(
                    text = { Text("ID ${gasto.gastoId} - ${gasto.suplidor}") },
                    onClick = {
                        selectedText = "ID ${gasto.gastoId} - ${gasto.suplidor}"
                        expanded = false
                        onSelect(gasto.gastoId)
                    }
                )
            }
        }
    }
}