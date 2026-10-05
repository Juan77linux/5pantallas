package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.model.Catalogo
import com.example.myapplication.model.ResumenPedido
import com.example.myapplication.navigation.Pantalla
import com.example.myapplication.ui.screens.PantallaConfirmacion
import com.example.myapplication.ui.screens.PantallaConversacion
import com.example.myapplication.ui.screens.PantallaInicio
import com.example.myapplication.ui.screens.PantallaRecomendacion
import com.example.myapplication.ui.screens.PantallaResumen
import com.example.myapplication.ui.theme.OrderBotTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrderBotTheme {
                OrderBotApp()
            }
        }
    }
}

/**
 * Raíz de la app: guarda el estado del flujo y decide qué
 * pantalla mostrar. No contiene UI propia; cada pantalla vive
 * en su archivo dentro de ui/screens.
 */
@Composable
fun OrderBotApp() {
    // rememberSaveable conserva el estado ante rotaciones y
    // muerte del proceso (con remember se perdía).
    var pantallaActual by rememberSaveable { mutableStateOf(Pantalla.INICIO) }
    var incluyeComplementos by rememberSaveable { mutableStateOf(false) }

    // when exhaustivo sobre el enum: si se agrega una pantalla,
    // el compilador obliga a manejarla aquí.
    when (pantallaActual) {
        Pantalla.INICIO -> PantallaInicio(
            onComenzar = { pantallaActual = Pantalla.CONVERSACION }
        )

        Pantalla.CONVERSACION -> PantallaConversacion(
            onSeleccionarProducto = { pantallaActual = Pantalla.RECOMENDACION }
        )

        Pantalla.RECOMENDACION -> PantallaRecomendacion(
            onAceptar = {
                incluyeComplementos = true
                pantallaActual = Pantalla.RESUMEN
            },
            onRechazar = {
                incluyeComplementos = false
                pantallaActual = Pantalla.RESUMEN
            }
        )

        Pantalla.RESUMEN -> PantallaResumen(
            resumen = construirResumen(incluyeComplementos),
            onConfirmar = { pantallaActual = Pantalla.CONFIRMACION }
        )

        Pantalla.CONFIRMACION -> PantallaConfirmacion(
            onVolverInicio = { pantallaActual = Pantalla.INICIO }
        )
    }
}

/**
 * Arma el pedido con los productos elegidos.
 * Al usar buildList, agregar nuevos productos al flujo
 * es una línea y no requiere cambiar la pantalla de resumen.
 */
private fun construirResumen(incluyeComplementos: Boolean) = ResumenPedido(
    productos = buildList {
        add(Catalogo.hamburguesa)
        if (incluyeComplementos) {
            add(Catalogo.papas)
            add(Catalogo.bebida)
        }
    }
)

@Preview(showBackground = true)
@Composable
private fun OrderBotPreview() {
    OrderBotTheme {
        OrderBotApp()
    }
}
