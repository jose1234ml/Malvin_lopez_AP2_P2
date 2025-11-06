package com.ebanisterialopez.malvin_lopez_ap2_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto.GastoScreen
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto.GastoCreateScreen
import com.ebanisterialopez.malvin_lopez_ap2_p2.presentation.gasto.GastoEditScreen
import com.ebanisterialopez.malvin_lopez_ap2_p2.ui.theme.Malvin_lopez_AP2_P2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Malvin_lopez_AP2_P2Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.List, contentDescription = "Lista") },
                    label = { Text("Gastos") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Add, contentDescription = "Nuevo") },
                    label = { Text("Nuevo") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Edit, contentDescription = "Editar") },
                    label = { Text("Editar") }
                )
            }
        }
    ) { innerPadding ->
        when (selectedTab) {
            0 -> GastoScreen(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
            1 -> GastoCreateScreen(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
            2 -> GastoEditScreen(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
        }
    }
}