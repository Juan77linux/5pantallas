package com.example.myapplication

// ============================================================
// IMPORTACIONES
// ============================================================

import android.os.Bundle

// Activity principal de Android.
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Componentes de diseño de Compose.
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

// Componentes visuales.
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text

// Estado de Compose.
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Herramientas de interfaz.
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// Permite mostrar imágenes en Compose.
import androidx.compose.foundation.Image

// Permite cargar imágenes desde res/drawable.
import androidx.compose.ui.res.painterResource

// ============================================================
// COLORES DE ORDERBOT
// ============================================================

// Color principal de la aplicación.
val AzulOrderBot = Color(0xFF2563EB)

// Color utilizado para destacar información.
val AzulClaroOrderBot = Color(0xFFEFF6FF)

// Fondo general de la aplicación.
val FondoOrderBot = Color(0xFFF8FAFC)

// Color del texto principal.
val TextoPrincipal = Color(0xFF172033)

// Color del texto secundario.
val TextoSecundario = Color(0xFF64748B)

// Color utilizado para confirmar acciones.
val VerdeOrderBot = Color(0xFF16A34A)


// ============================================================
// ACTIVITY PRINCIPAL
// ============================================================

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite utilizar toda la pantalla.
        enableEdgeToEdge()

        // Iniciamos nuestra aplicación Compose.
        setContent {
            OrderBotApp()
        }
    }
}


// ============================================================
// APLICACIÓN PRINCIPAL
// ============================================================

@Composable
fun OrderBotApp() {

    // Controla la pantalla que estamos mostrando.
    //
    // 1 = Inicio
    // 2 = Conversación
    // 3 = Recomendación
    // 4 = Resumen
    // 5 = Confirmación
    var pantallaActual by remember {
        mutableStateOf(1)
    }

    // Indica si el usuario agregó papas y bebida.
    var agregoComplementos by remember {
        mutableStateOf(false)
    }


    // ========================================================
    // CONTROL DE PANTALLAS
    // ========================================================

    when (pantallaActual) {

        // ----------------------------------------------------
        // PANTALLA 1
        // ----------------------------------------------------

        1 -> {

            PantallaInicio(
                comenzarPedido = {
                    pantallaActual = 2
                }
            )
        }


        // ----------------------------------------------------
        // PANTALLA 2
        // ----------------------------------------------------

        2 -> {

            PantallaConversacion(
                seleccionarHamburguesa = {
                    pantallaActual = 3
                }
            )
        }


        // ----------------------------------------------------
        // PANTALLA 3
        // ----------------------------------------------------

        3 -> {

            PantallaRecomendacion(

                // El usuario acepta papas y bebida.
                aceptar = {

                    agregoComplementos = true
                    pantallaActual = 4
                },

                // El usuario no quiere los complementos.
                rechazar = {

                    agregoComplementos = false
                    pantallaActual = 4
                }
            )
        }


        // ----------------------------------------------------
        // PANTALLA 4
        // ----------------------------------------------------

        4 -> {

            PantallaResumen(

                tieneComplementos = agregoComplementos,

                confirmar = {
                    pantallaActual = 5
                }
            )
        }


        // ----------------------------------------------------
        // PANTALLA 5
        // ----------------------------------------------------

        5 -> {

            PantallaConfirmacion(

                volverInicio = {
                    pantallaActual = 1
                }
            )
        }
    }
}


// ============================================================
// PANTALLA 1 - INICIO
// ============================================================

@Composable
fun PantallaInicio(
    comenzarPedido: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        // ----------------------------------------------------
        // LOGO
        // ----------------------------------------------------

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = AzulClaroOrderBot,
                    shape = RoundedCornerShape(28.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            // Mostramos nuestro logo de OrderBot.
            Image(
                painter = painterResource(
                    id = R.drawable.logo_bot1
                ),
                contentDescription = "Logo de OrderBot",

                // Ajustamos el tamaño del logo.
                modifier = Modifier.size(300.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // NOMBRE
        // ----------------------------------------------------

        Text(
            text = "OrderBot",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )


        // ----------------------------------------------------
        // FRASE PRINCIPAL
        // ----------------------------------------------------

        Text(
            text = "¡Pide fácil, recibe rápido!",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = AzulOrderBot,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // ----------------------------------------------------
        // BENEFICIOS
        // ----------------------------------------------------

        TarjetaBeneficio(
            icono = "⚡",
            titulo = "Atención instantánea",
            descripcion = "Disponible las 24 horas."
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        TarjetaBeneficio(
            icono = "✨",
            titulo = "Sugerencias personalizadas",
            descripcion = "Encuentra opciones según tu pedido."
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // ----------------------------------------------------
        // BOTÓN COMENZAR
        // ----------------------------------------------------

        Button(
            onClick = {
                comenzarPedido()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(16.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Comenzar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


// ============================================================
// TARJETA DE BENEFICIO
// ============================================================

@Composable
fun TarjetaBeneficio(
    icono: String,
    titulo: String,
    descripcion: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = icono,
                fontSize = 28.sp
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column {

                Text(
                    text = titulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Text(
                    text = descripcion,
                    fontSize = 14.sp,
                    color = TextoSecundario
                )
            }
        }
    }
}


// ============================================================
// PANTALLA 2 - CONVERSACIÓN
// ============================================================

@Composable
fun PantallaConversacion(
    seleccionarHamburguesa: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(20.dp)
    ) {

        // ----------------------------------------------------
        // ENCABEZADO
        // ----------------------------------------------------

        Text(
            text = "OrderBot 💬",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )

        Text(
            text = "Asistente de pedidos",
            fontSize = 14.sp,
            color = TextoSecundario
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // MENSAJE DEL BOT
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "Hola 👋",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "¿Qué deseas pedir hoy?",
                    fontSize = 16.sp,
                    color = TextoPrincipal
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // PRODUCTO 1
        // ----------------------------------------------------

        TarjetaProducto(
            emoji = "🍔",
            nombre = "Hamburguesa",
            descripcion = "Hamburguesa clásica",
            precio = "$20.000",
            seleccionar = {
                seleccionarHamburguesa()
            }
        )

        Spacer(
            modifier = Modifier.height(14.dp)
        )


        // ----------------------------------------------------
        // PRODUCTO 2
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "🍕",
                    fontSize = 40.sp
                )

                Spacer(
                    modifier = Modifier.width(14.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Pizza",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoPrincipal
                    )

                    Text(
                        text = "Opción disponible próximamente",
                        fontSize = 13.sp,
                        color = TextoSecundario
                    )
                }
            }
        }
    }
}


// ============================================================
// TARJETA DE PRODUCTO
// ============================================================

@Composable
fun TarjetaProducto(
    emoji: String,
    nombre: String,
    descripcion: String,
    precio: String,
    seleccionar: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = emoji,
                fontSize = 42.sp
            )

            Spacer(
                modifier = Modifier.width(14.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = nombre,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoPrincipal
                )

                Text(
                    text = descripcion,
                    fontSize = 13.sp,
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = precio,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulOrderBot
                )
            }

            Button(
                onClick = {
                    seleccionar()
                },

                shape = RoundedCornerShape(12.dp)
            ) {

                Text(
                    text = "Elegir"
                )
            }
        }
    }
}


// ============================================================
// PANTALLA 3 - RECOMENDACIÓN
// ============================================================

@Composable
fun PantallaRecomendacion(
    aceptar: () -> Unit,
    rechazar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "🍔",
            fontSize = 70.sp
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = "¡Excelente elección!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "¿Quieres completar tu pedido?",
            fontSize = 18.sp,
            color = TextoPrincipal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Agrega papas y bebida por un precio adicional.",
            fontSize = 15.sp,
            color = TextoSecundario,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(28.dp)
        )


        // ----------------------------------------------------
        // COMPLEMENTOS
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "🍟 Papas",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$5.000",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "🥤 Bebida",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$4.000",
                    color = TextoSecundario
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // BOTÓN ACEPTAR
        // ----------------------------------------------------

        Button(
            onClick = {
                aceptar()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(14.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Sí, claro"
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        // ----------------------------------------------------
        // BOTÓN RECHAZAR
        // ----------------------------------------------------

        OutlinedButton(
            onClick = {
                rechazar()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "No, gracias"
            )
        }
    }
}


// ============================================================
// PANTALLA 4 - RESUMEN
// ============================================================

@Composable
fun PantallaResumen(
    tieneComplementos: Boolean,
    confirmar: () -> Unit
) {

    // Precios del ejemplo.
    val precioHamburguesa = 20000
    val precioPapas = 5000
    val precioBebida = 4000
    val precioEnvio = 5000

    // Calculamos el subtotal dependiendo
    // de lo que seleccionó el usuario.
    val subtotal = if (tieneComplementos) {
        precioHamburguesa + precioPapas + precioBebida
    } else {
        precioHamburguesa
    }

    // Sumamos el costo de envío.
    val total = subtotal + precioEnvio

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(20.dp)
    ) {

        Text(
            text = "Resumen del pedido",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // ----------------------------------------------------
        // PRODUCTOS
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "Productos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                FilaPrecio(
                    nombre = "🍔 Hamburguesa",
                    precio = "$20.000"
                )

                if (tieneComplementos) {

                    FilaPrecio(
                        nombre = "🍟 Papas",
                        precio = "$5.000"
                    )

                    FilaPrecio(
                        nombre = "🥤 Bebida",
                        precio = "$4.000"
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Divider()

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                FilaPrecio(
                    nombre = "Subtotal",
                    precio = "$${subtotal.formatear()}"
                )

                FilaPrecio(
                    nombre = "Envío",
                    precio = "$${precioEnvio.formatear()}"
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Divider()

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                FilaPrecio(
                    nombre = "TOTAL",
                    precio = "$${total.formatear()}",
                    destacado = true
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // ----------------------------------------------------
        // ENTREGA
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    text = "🚚 Entrega",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Dirección: Por definir",
                    color = TextoSecundario
                )

                Text(
                    text = "Pago: Por definir",
                    color = TextoSecundario
                )
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // ----------------------------------------------------
        // CONFIRMAR
        // ----------------------------------------------------

        Button(
            onClick = {
                confirmar()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(16.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AzulOrderBot
            )
        ) {

            Text(
                text = "Confirmar Pedido",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


// ============================================================
// FILA DE PRECIO
// ============================================================

@Composable
fun FilaPrecio(
    nombre: String,
    precio: String,
    destacado: Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = nombre,
            fontSize = if (destacado) 18.sp else 15.sp,
            fontWeight = if (destacado) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },

            color = if (destacado) {
                TextoPrincipal
            } else {
                TextoSecundario
            }
        )

        Text(
            text = precio,
            fontSize = if (destacado) 18.sp else 15.sp,
            fontWeight = FontWeight.Bold,
            color = if (destacado) {
                AzulOrderBot
            } else {
                TextoPrincipal
            }
        )
    }
}


// ============================================================
// PANTALLA 5 - CONFIRMACIÓN
// ============================================================

@Composable
fun PantallaConfirmacion(
    volverInicio: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOrderBot)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        // ----------------------------------------------------
        // ICONO DE CONFIRMACIÓN
        // ----------------------------------------------------

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color(0xFFE8F5E9),
                    shape = RoundedCornerShape(50.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "✓",
                fontSize = 58.sp,
                fontWeight = FontWeight.Bold,
                color = VerdeOrderBot
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // MENSAJE
        // ----------------------------------------------------

        Text(
            text = "¡Pedido confirmado!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoPrincipal,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Tu pedido ha sido recibido correctamente.",
            fontSize = 16.sp,
            color = TextoSecundario,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // INFORMACIÓN DEL PEDIDO
        // ----------------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(18.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Pedido #1024",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "⏱️ Entrega estimada: 30 - 40 minutos",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "💳 Método de pago: Por definir",
                    color = TextoSecundario
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "📦 Estado: Pedido recibido",
                    color = TextoSecundario
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // ----------------------------------------------------
        // SEGUIMIENTO
        // ----------------------------------------------------

        Button(
            onClick = {
                // Esta función puede conectarse
                // posteriormente a un seguimiento real.
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "Seguir pedido en vivo"
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )


        // ----------------------------------------------------
        // VOLVER AL INICIO
        // ----------------------------------------------------

        OutlinedButton(
            onClick = {
                volverInicio()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(14.dp)
        ) {

            Text(
                text = "Volver al inicio"
            )
        }
    }
}


// ============================================================
// FUNCIÓN PARA FORMATEAR PRECIOS
// ============================================================

// Esta función convierte un número como:
//
// 29000
//
// en:
//
// 29.000
//
// para mostrarlo de una forma más cómoda.
fun Int.formatear(): String {

    return this
        .toString()
        .reversed()
        .chunked(3)
        .joinToString(".")
        .reversed()
}


// ============================================================
// VISTA PREVIA
// ============================================================

@Preview(showBackground = true)
@Composable
fun OrderBotPreview() {

    // Mostramos la aplicación completa
    // en la vista previa de Android Studio.
    OrderBotApp()
}