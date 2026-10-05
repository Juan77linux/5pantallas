package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.Catalogo
import com.example.myapplication.ui.components.OrderBotCard
import com.example.myapplication.ui.components.TarjetaProducto
import com.example.myapplication.ui.theme.OrderBotTheme
import com.example.myapplication.util.aPrecio

/**
 * Pantalla 2: el bot saluda y muestra el catálogo.
 *
 * @param onSeleccionarProducto navega a la recomendación de complementos.
 */
@Composable
fun PantallaConversacion(onSeleccionarProducto: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .padding(20.dp)
    ) {
        // Encabezado
        Text(
            text = stringResource(R.string.conversacion_titulo),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = stringResource(R.string.conversacion_subtitulo),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mensaje del bot
        OrderBotCard {
            Text(
                text = stringResource(R.string.conversacion_saludo),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(R.string.conversacion_pregunta),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Producto disponible: los datos vienen del catálogo,
        // ya no hay precios escritos a mano en la UI.
        val hamburguesa = Catalogo.hamburguesa
        TarjetaProducto(
            emoji = hamburguesa.emoji,
            nombre = stringResource(hamburguesa.nombreRes),
            descripcion = hamburguesa.descripcionRes?.let { stringResource(it) },
            precio = hamburguesa.precio.aPrecio(),
            accion = {
                Button(
                    onClick = onSeleccionarProducto,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = stringResource(R.string.producto_boton_elegir))
                }
            }
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Producto próximamente: reutiliza la misma tarjeta,
        // sin precio ni botón (antes duplicaba todo el layout).
        val pizza = Catalogo.pizza
        TarjetaProducto(
            emoji = pizza.emoji,
            nombre = stringResource(pizza.nombreRes),
            descripcion = pizza.descripcionRes?.let { stringResource(it) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaConversacionPreview() {
    OrderBotTheme {
        PantallaConversacion(onSeleccionarProducto = {})
    }
}
