package com.unicomicoptero.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unicomicoptero.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CalificacionApp()
            }
        }
    }
}

@Composable
fun CalificacionApp() {
    var notaTexto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Conversor de Calificación",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = notaTexto,
                    onValueChange = { notaTexto = it },
                    label = { Text("Ingresa tu nota") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val nota = notaTexto.toIntOrNull()
                    resultado = if (nota != null) {
                        when {
                            nota >= 90 -> "A"
                            nota >= 80 -> "B"
                            nota >= 70 -> "C"
                            else -> "F"
                        }
                    } else {
                        "Nota inválida"
                    }
                }) {
                    Text("Calcular")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Resultado: $resultado",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = R.drawable.photo),
                    contentDescription = "Foto",
                    modifier = Modifier.size(150.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Diego Garabito - 2021-1302",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
