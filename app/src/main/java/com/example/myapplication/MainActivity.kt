package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.model.ModoTema
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.ui.screens.PantallaInicio
import com.example.myapplication.ui.theme.OrderBotTheme
import com.example.myapplication.viewmodel.TemaViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrderBotApp()
        }
    }
}

/**
 * Raíz de la app: decide el tema a partir del TemaViewModel
 * y delega la navegación al NavHost (AppNavigation).
 *
 * Ya no guarda el estado del pedido ni la pantalla actual:
 * eso ahora es responsabilidad del PedidoViewModel y del NavController.
 */
@Composable
fun OrderBotApp(
    temaViewModel: TemaViewModel = viewModel()
) {
    // Estado observado del ViewModel: sobrevive a rotaciones.
    val modoTema by temaViewModel.modoTema.collectAsStateWithLifecycle()

    // Detección de la preferencia del sistema; solo aplica en modo SISTEMA.
    val sistemaOscuro = isSystemInDarkTheme()
    val temaOscuro = when (modoTema) {
        ModoTema.SISTEMA -> sistemaOscuro
        ModoTema.CLARO -> false
        ModoTema.OSCURO -> true
    }

    // Pinta los íconos de las barras del sistema (hora, batería...)
    // en claro u oscuro según el tema activo para que sean legibles.
    val vista = LocalView.current
    if (!vista.isInEditMode) {
        SideEffect {
            val ventana = (vista.context as Activity).window
            WindowCompat.getInsetsController(ventana, vista).apply {
                isAppearanceLightStatusBars = !temaOscuro
                isAppearanceLightNavigationBars = !temaOscuro
            }
        }
    }

    OrderBotTheme(darkTheme = temaOscuro) {
        AppNavigation(
            modoTema = modoTema,
            onCambiarTema = temaViewModel::cambiarModoTema
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderBotPreview() {
    // Se previsualiza una sola pantalla: AppNavigation necesita un
    // NavController real y ViewModels, no disponibles en previews.
    OrderBotTheme {
        PantallaInicio(
            onComenzar = {},
            modoTema = ModoTema.SISTEMA,
            onCambiarTema = {}
        )
    }
}
