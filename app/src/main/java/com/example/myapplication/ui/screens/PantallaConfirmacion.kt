package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.components.BotonPrimario
import com.example.myapplication.ui.components.BotonSecundario
import com.example.myapplication.ui.components.OrderBotCard
import com.example.myapplication.ui.theme.OrderBotTheme

/**
 * Pantalla 5: confirmación del pedido realizado.
 *
 * @param onVolverInicio reinicia el flujo volviendo a la pantalla inicial.
 */
@Composable
fun PantallaConfirmacion(onVolverInicio: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Ícono de éxito: se usa el color "tertiary" del tema
        // (verde de marca) en lugar de un valor fijo.
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                fontSize = 58.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.confirmacion_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.confirmacion_mensaje),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Información del pedido
        OrderBotCard {
            Text(
                text = stringResource(R.string.confirmacion_numero_pedido),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.confirmacion_entrega_estimada),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(R.string.confirmacion_metodo_pago),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(R.string.confirmacion_estado),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        BotonPrimario(
            texto = stringResource(R.string.confirmacion_boton_seguir),
            onClick = {
                // Pendiente: conectar con el seguimiento en vivo.
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        BotonSecundario(
            texto = stringResource(R.string.confirmacion_boton_volver),
            onClick = onVolverInicio
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaConfirmacionPreview() {
    OrderBotTheme {
        PantallaConfirmacion(onVolverInicio = {})
    }
}
