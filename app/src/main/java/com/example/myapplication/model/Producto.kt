package com.example.myapplication.model

import androidx.annotation.StringRes
import com.example.myapplication.R

/**
 * Producto del menú.
 *
 * Los textos se guardan como referencias a recursos (@StringRes)
 * para respetar la localización de Android; el precio siempre
 * se maneja como entero en pesos (nunca como texto).
 */
data class Producto(
    @StringRes val nombreRes: Int,
    val emoji: String,
    val precio: Int,
    @StringRes val descripcionRes: Int? = null
)

/**
 * Catálogo: única fuente de verdad para productos y precios.
 *
 * Antes los precios estaban duplicados como texto ("$20.000")
 * y como números (20000) en pantallas distintas; ahora solo
 * se definen aquí.
 */
object Catalogo {

    const val PRECIO_ENVIO = 5_000

    val hamburguesa = Producto(
        nombreRes = R.string.producto_hamburguesa,
        emoji = "🍔",
        precio = 20_000,
        descripcionRes = R.string.producto_hamburguesa_desc
    )

    val papas = Producto(
        nombreRes = R.string.producto_papas,
        emoji = "🍟",
        precio = 5_000
    )

    val bebida = Producto(
        nombreRes = R.string.producto_bebida,
        emoji = "🥤",
        precio = 4_000
    )

    /** Producto de muestra aún no disponible para pedir. */
    val pizza = Producto(
        nombreRes = R.string.producto_pizza,
        emoji = "🍕",
        precio = 0,
        descripcionRes = R.string.producto_pizza_desc
    )
}
