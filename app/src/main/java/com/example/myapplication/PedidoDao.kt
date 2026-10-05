package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PedidoDao {

    @Insert
    suspend fun insertarPedido(pedido: PedidoEntity)

    @Query("SELECT * FROM pedidos ORDER BY id DESC")
    suspend fun obtenerPedidos(): List<PedidoEntity>
}