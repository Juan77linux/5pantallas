package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.ModoTema
import com.example.myapplication.ui.components.BotonModoTema
import com.example.myapplication.ui.components.BotonPrimario
import com.example.myapplication.ui.components.TarjetaBeneficio
import com.example.myapplication.ui.theme.OrderBotTheme

/**
 * Pantalla 1: bienvenida y beneficios de OrderBot.
 *
 * @param onComenzar navega a la pantalla de conversación.
 * @param modoTema modo de tema activo (para el botón de cambio).
 * @param onCambiarTema alterna claro → oscuro → automático.
 */
@Composable
fun PantallaInicio(
    onComenzar: () -> Unit,
    modoTema: ModoTema,
    onCambiarTema: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            // Respeta las barras del sistema con enableEdgeToEdge.
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

        // Logo
        Box(
            modifier = Modifier
                .size(160.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(44.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_bot1),
                contentDescription = stringResource(R.string.logo_descripcion),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.app_name),
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.inicio_eslogan),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        TarjetaBeneficio(
            icono = "⚡",
            titulo = stringResource(R.string.inicio_beneficio_rapido_titulo),
            descripcion = stringResource(R.string.inicio_beneficio_rapido_desc)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TarjetaBeneficio(
            icono = "✨",
            titulo = stringResource(R.string.inicio_beneficio_sugerencias_titulo),
            descripcion = stringResource(R.string.inicio_beneficio_sugerencias_desc)
        )

        Spacer(modifier = Modifier.height(32.dp))

        BotonPrimario(
            texto = stringResource(R.string.inicio_boton_comenzar),
            onClick = onComenzar
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaInicioPreview() {
    OrderBotTheme {
        PantallaInicio(
            onComenzar = {},
            modoTema = ModoTema.SISTEMA,
            onCambiarTema = {}
        )
    }
}
