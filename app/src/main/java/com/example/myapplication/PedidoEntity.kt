package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedidos")
data class PedidoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val producto: String,
    val complementos: Boolean,
    val total: Int,
    val estado: String
)