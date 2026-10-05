package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.AzulOrderBot
import com.example.myapplication.FondoOrderBot
import com.example.myapplication.TextoPrincipal
import com.example.myapplication.TextoSecundario
import com.example.myapplication.VerdeOrderBot

@Composable
fun PantallaConfirmacion(
    estadoOnline: String,
    volverInicio: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "✓",
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeOrderBot
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "¡Pedido confirmado!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Tu pedido ha sido registrado correctamente.",
            fontSize = 16.sp,
            color = TextoSecundario,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Pedido #1024",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Entrega estimada: 30 - 40 minutos",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Método de pago: Contra entrega",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Estado: Confirmado",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "🌐 Servicio: $estadoOnline",
                    fontWeight = FontWeight.Bold,
                    color = if (estadoOnline == "Sin conexión") {
                        TextoSecundario
                    } else {
                        VerdeOrderBot
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                // Función pendiente para seguimiento en vivo.
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Seguir pedido en vivo"
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                volverInicio()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Volver al inicio"
            )
        }
    }
}