package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.myapplication.AzulClaroOrderBot
import com.example.myapplication.AzulOrderBot
import com.example.myapplication.FondoOrderBot
import com.example.myapplication.TextoPrincipal
import com.example.myapplication.TextoSecundario

@Composable
fun PantallaConversacion(
    onSeleccionarProducto: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "¡Hola! Soy OrderBot 🤖",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "¿Qué deseas pedir hoy?",
            fontSize = 17.sp,
            color = TextoSecundario,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = AzulClaroOrderBot
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🍔 Hamburguesa",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Hamburguesa clásica con carne, " +
                            "queso, lechuga y tomate.",
                    fontSize = 15.sp,
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "$20.000",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulOrderBot
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Button(
                    onClick = {
                        onSeleccionarProducto()
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulOrderBot
                    )
                ) {

                    Text(
                        text = "Elegir"
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = androidx.compose.ui.graphics.Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🍕 Pizza",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Próximamente podrás pedir pizza.",
                    fontSize = 15.sp,
                    color = TextoSecundario
                )
            }
        }
    }
}