package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.example.myapplication.AzulClaroOrderBot
import com.example.myapplication.AzulOrderBot
import com.example.myapplication.FondoOrderBot
import com.example.myapplication.R
import com.example.myapplication.TextoPrincipal
import com.example.myapplication.TextoSecundario

@Composable
fun PantallaInicio(
    comenzarPedido: () -> Unit,
    acercaDe: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.logo_bot1
            ),

            contentDescription = "Logo de OrderBot",

            modifier = Modifier.size(130.dp)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "OrderBot",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "¡Pide fácil, recibe rápido!",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = AzulOrderBot,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = AzulClaroOrderBot
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "⚡ Atención instantánea",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "Disponible las 24 horas.",
                    fontSize = 14.sp,
                    color = TextoSecundario
                )
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = AzulClaroOrderBot
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "✨ Sugerencias personalizadas",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "Encuentra opciones según tu pedido.",
                    fontSize = 14.sp,
                    color = TextoSecundario
                )
            }
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        Button(
            onClick = {
                comenzarPedido()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(16.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Comenzar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedButton(
            onClick = {
                acercaDe()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "Acerca de OrderBot",
                color = TextoPrincipal
            )
        }
    }
}