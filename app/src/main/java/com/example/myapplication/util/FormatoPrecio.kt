package com.example.myapplication.util

import java.text.NumberFormat
import java.util.Locale

/**
 * Formateador de pesos colombianos (es-CO usa "." como
 * separador de miles). Se reutiliza una sola instancia
 * porque crear un [NumberFormat] es costoso y solo se
 * usa desde el hilo principal de la UI.
 */
private val formatoMiles = NumberFormat.getInstance(Locale.forLanguageTag("es-CO"))

/**
 * Convierte un valor en pesos a texto legible.
 *
 * Ejemplo: 29000 -> "$29.000"
 *
 * Reemplaza la implementación manual con reversed()/chunked(),
 * que además de más lenta no respeta las reglas del idioma.
 */
fun Int.aPrecio(): String = "$" + formatoMiles.format(this)
