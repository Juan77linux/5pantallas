package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
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
import com.example.myapplication.model.Catalogo
import com.example.myapplication.model.ModoTema
import com.example.myapplication.ui.components.BotonModoTema
import com.example.myapplication.ui.components.BotonPrimario
import com.example.myapplication.ui.components.BotonSecundario
import com.example.myapplication.ui.components.OrderBotCard
import com.example.myapplication.ui.theme.OrderBotTheme
import com.example.myapplication.util.aPrecio

/**
 * Pantalla 3: ofrece agregar papas y bebida al pedido.
 *
 * @param onAceptar el usuario acepta los complementos.
 * @param onRechazar el usuario continúa sin complementos.
 * @param modoTema modo de tema activo (para el botón de cambio).
 * @param onCambiarTema alterna claro → oscuro → automático.
 */
@Composable
fun PantallaRecomendacion(
    onAceptar: () -> Unit,
    onRechazar: () -> Unit,
    modoTema: ModoTema,
    onCambiarTema: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Selector de tema en la esquina superior derecha.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            BotonModoTema(modo = modoTema, onClick = onCambiarTema)
        }

        Text(text = Catalogo.hamburguesa.emoji, fontSize = 70.sp)

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = stringResource(R.string.recomendacion_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.recomendacion_pregunta),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.recomendacion_detalle),
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Complementos ofrecidos: datos desde el catálogo.
        OrderBotCard {
            ComplementoItem(emoji = Catalogo.papas.emoji, nombreRes = Catalogo.papas.nombreRes, precio = Catalogo.papas.precio)
            Spacer(modifier = Modifier.height(8.dp))
            ComplementoItem(emoji = Catalogo.bebida.emoji, nombreRes = Catalogo.bebida.nombreRes, precio = Catalogo.bebida.precio)
        }

        Spacer(modifier = Modifier.height(24.dp))

        BotonPrimario(
            texto = stringResource(R.string.recomendacion_boton_aceptar),
            onClick = onAceptar
        )

        Spacer(modifier = Modifier.height(10.dp))

        BotonSecundario(
            texto = stringResource(R.string.recomendacion_boton_rechazar),
            onClick = onRechazar
        )
    }
}

/** Nombre + precio de un complemento dentro de la tarjeta. */
@Composable
private fun ComplementoItem(
    emoji: String,
    nombreRes: Int,
    precio: Int
) {
    Text(
        text = "$emoji ${stringResource(nombreRes)}",
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface
    )
    Text(
        text = precio.aPrecio(),
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Preview(showBackground = true)
@Composable
private fun PantallaRecomendacionPreview() {
    OrderBotTheme {
        PantallaRecomendacion(
            onAceptar = {},
            onRechazar = {},
            modoTema = ModoTema.SISTEMA,
            onCambiarTema = {}
        )
    }
}
