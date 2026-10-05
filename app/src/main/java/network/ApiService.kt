package com.example.myapplication.network

import retrofit2.http.GET

interface ApiService {

    @GET("todos/1")
    suspend fun obtenerEstado(): EstadoOnline
}