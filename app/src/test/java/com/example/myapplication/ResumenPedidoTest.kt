package com.example.myapplication

import com.example.myapplication.model.Catalogo
import com.example.myapplication.model.ResumenPedido
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Pruebas de la lógica de negocio del pedido.
 * Al extraerla de la UI se puede verificar sin emulador.
 */
class ResumenPedidoTest {

    @Test
    fun `subtotal sin complementos solo incluye la hamburguesa`() {
        val resumen = ResumenPedido(productos = listOf(Catalogo.hamburguesa))

        assertEquals(20_000, resumen.subtotal)
    }

    @Test
    fun `subtotal con complementos suma todos los productos`() {
        val resumen = ResumenPedido(
            productos = listOf(Catalogo.hamburguesa, Catalogo.papas, Catalogo.bebida)
        )

        assertEquals(29_000, resumen.subtotal)
    }

    @Test
    fun `total agrega el costo de envio al subtotal`() {
        val resumen = ResumenPedido(productos = listOf(Catalogo.hamburguesa))

        assertEquals(20_000 + Catalogo.PRECIO_ENVIO, resumen.total)
    }

    @Test
    fun `total respeta un envio personalizado`() {
        val resumen = ResumenPedido(
            productos = listOf(Catalogo.hamburguesa),
            precioEnvio = 3_000
        )

        assertEquals(23_000, resumen.total)
    }
}
