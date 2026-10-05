package com.example.myapplication

import com.example.myapplication.util.aPrecio
import org.junit.Assert.assertEquals
import org.junit.Test

class FormatoPrecioTest {

    @Test
    fun `formatea miles con punto y signo de pesos`() {
        assertEquals("$29.000", 29_000.aPrecio())
    }

    @Test
    fun `valores menores a mil no llevan separador`() {
        assertEquals("$500", 500.aPrecio())
    }

    @Test
    fun `el cero se formatea correctamente`() {
        assertEquals("$0", 0.aPrecio())
    }
}
