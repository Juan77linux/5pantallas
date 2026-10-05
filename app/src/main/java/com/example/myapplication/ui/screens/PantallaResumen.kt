package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.HorizontalDivider
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
import com.example.myapplication.model.ResumenPedido
import com.example.myapplication.ui.components.BotonPrimario
import com.example.myapplication.ui.components.FilaPrecio
import com.example.myapplication.ui.components.OrderBotCard
import com.example.myapplication.ui.theme.OrderBotTheme
import com.example.myapplication.util.aPrecio

/**
 * Pantalla 4: detalle del pedido antes de confirmar.
 *
 * Recibe un [ResumenPedido] ya calculado: la pantalla solo
 * muestra datos, no contiene lógica de negocio.
 *
 * @param onConfirmar navega a la pantalla de confirmación.
 */
@Composable
fun PantallaResumen(
    resumen: ResumenPedido,
    onConfirmar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.resumen_titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Productos y totales
        OrderBotCard {
            Text(
                text = stringResource(R.string.resumen_seccion_productos),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Se genera una fila por producto elegido: agregar un
            // producto al pedido ya no requiere tocar esta pantalla.
            resumen.productos.forEach { producto ->
                FilaPrecio(
                    nombre = "${producto.emoji} ${stringResource(producto.nombreRes)}",
                    precio = producto.precio.aPrecio()
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            FilaPrecio(
                nombre = stringResource(R.string.resumen_subtotal),
                precio = resumen.subtotal.aPrecio()
            )
            FilaPrecio(
                nombre = stringResource(R.string.resumen_envio),
                precio = resumen.precioEnvio.aPrecio()
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            FilaPrecio(
                nombre = stringResource(R.string.resumen_total),
                precio = resumen.total.aPrecio(),
                destacado = true
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Datos de entrega
        OrderBotCard {
            Text(
                text = stringResource(R.string.resumen_seccion_entrega),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.resumen_direccion),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = stringResource(R.string.resumen_pago),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        BotonPrimario(
            texto = stringResource(R.string.resumen_boton_confirmar),
            onClick = onConfirmar
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaResumenPreview() {
    OrderBotTheme {
        PantallaResumen(
            resumen = ResumenPedido(
                productos = listOf(Catalogo.hamburguesa, Catalogo.papas, Catalogo.bebida)
            ),
            onConfirmar = {}
        )
    }
}
