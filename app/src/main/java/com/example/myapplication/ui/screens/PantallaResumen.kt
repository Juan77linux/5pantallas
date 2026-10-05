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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.AzulClaroOrderBot
import com.example.myapplication.AzulOrderBot
import com.example.myapplication.FondoOrderBot
import com.example.myapplication.TextoPrincipal
import com.example.myapplication.TextoSecundario
import com.example.myapplication.VerdeOrderBot

@Composable
fun PantallaResumen(
    tieneComplementos: Boolean,
    confirmar: () -> Unit
) {

    val precioHamburguesa = 20000
    val precioPapas = if (tieneComplementos) 5000 else 0
    val precioBebida = if (tieneComplementos) 4000 else 0
    val domicilio = 5000

    val total = precioHamburguesa + precioPapas + precioBebida + domicilio

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Resumen del pedido",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )

        Spacer(
            modifier = Modifier.height(24.dp)
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                FilaPrecio(
                    nombre = "Hamburguesa",
                    precio = precioHamburguesa
                )

                if (tieneComplementos) {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    FilaPrecio(
                        nombre = "🍟 Papas fritas",
                        precio = precioPapas
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    FilaPrecio(
                        nombre = "🥤 Bebida",
                        precio = precioBebida
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                FilaPrecio(
                    nombre = "Domicilio",
                    precio = domicilio
                )
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = VerdeOrderBot.copy(alpha = 0.12f)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Total",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "$total",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = VerdeOrderBot
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                confirmar()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(14.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Confirmar pedido",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FilaPrecio(
    nombre: String,
    precio: Int
) {

    androidx.compose.foundation.layout.Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = nombre,
            color = TextoSecundario,
            fontSize = 15.sp
        )

        Text(
            text = "$precio",
            color = TextoPrincipal,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
    }
}