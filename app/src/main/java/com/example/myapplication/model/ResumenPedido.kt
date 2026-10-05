package com.example.myapplication.model

/**
 * Lógica de negocio del pedido.
 *
 * Extraída de la UI para que sea testeable con pruebas
 * unitarias simples (ver ResumenPedidoTest).
 */
data class ResumenPedido(
    val productos: List<Producto>,
    val precioEnvio: Int = Catalogo.PRECIO_ENVIO
) {
    /** Suma de los precios de los productos elegidos. */
    val subtotal: Int
        get() = productos.sumOf { it.precio }

    /** Subtotal más el costo de envío. */
    val total: Int
        get() = subtotal + precioEnvio
}
