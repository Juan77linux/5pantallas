package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderBotViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)
    private val pedidoDao = database.pedidoDao()

    private val _pantallaActual = MutableStateFlow(1)
    val pantallaActual: StateFlow<Int> = _pantallaActual

    private val _agregoComplementos = MutableStateFlow(false)
    val agregoComplementos: StateFlow<Boolean> = _agregoComplementos

    private val _estadoOnline = MutableStateFlow("Sin consultar")
    val estadoOnline: StateFlow<String> = _estadoOnline

    fun irA(pantalla: Int) {
        _pantallaActual.value = pantalla
    }

    fun seleccionarComplementos(agregar: Boolean) {
        _agregoComplementos.value = agregar
    }

    fun guardarPedido() {

        val pedido = PedidoEntity(
            producto = "Hamburguesa",
            complementos = _agregoComplementos.value,
            total = if (_agregoComplementos.value) 34000 else 25000,
            estado = "Confirmado"
        )

        viewModelScope.launch {
            pedidoDao.insertarPedido(pedido)
        }
    }

    fun consultarServicioOnline() {

        viewModelScope.launch {

            try {

                val respuesta = RetrofitClient.api.obtenerEstado()

                _estadoOnline.value =
                    if (respuesta.completed) {
                        "Servicio online activo"
                    } else {
                        "Servicio online disponible"
                    }

            } catch (e: Exception) {

                _estadoOnline.value = "Sin conexión"

            }
        }
    }
}