package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Tarjeta de producto del catálogo.
 *
 * Usa una API de "slots" ([accion]): quien la invoca decide qué
 * poner al final de la fila (un botón, nada, etc.). Así la misma
 * tarjeta sirve para productos seleccionables y para productos
 * "próximamente", sin duplicar el layout.
 *
 * @param descripcion Texto secundario, o null para ocultarlo.
 * @param precio Texto del precio, o null para ocultarlo.
 * @param accion Contenido opcional al final de la fila (p. ej. un botón).
 */
@Composable
fun TarjetaProducto(
    emoji: String,
    nombre: String,
    modifier: Modifier = Modifier,
    descripcion: String? = null,
    precio: String? = null,
    accion: (@Composable () -> Unit)? = null
) {
    OrderBotCard(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = emoji, fontSize = 40.sp)

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = nombre,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (descripcion != null) {
                    Text(
                        text = descripcion,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (precio != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = precio,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (accion != null) {
                Spacer(modifier = Modifier.width(12.dp))
                accion()
            }
        }
    }
}
