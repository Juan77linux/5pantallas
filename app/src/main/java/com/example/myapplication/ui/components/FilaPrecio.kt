package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Fila "concepto -> precio" usada en el resumen del pedido.
 *
 * @param destacado true para la fila del total (más grande y en color primario).
 */
@Composable
fun FilaPrecio(
    nombre: String,
    precio: String,
    modifier: Modifier = Modifier,
    destacado: Boolean = false
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = nombre,
            fontSize = if (destacado) 18.sp else 15.sp,
            fontWeight = if (destacado) FontWeight.Bold else FontWeight.Normal,
            color = if (destacado) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
        Text(
            text = precio,
            fontSize = if (destacado) 18.sp else 15.sp,
            fontWeight = FontWeight.Bold,
            color = if (destacado) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}
