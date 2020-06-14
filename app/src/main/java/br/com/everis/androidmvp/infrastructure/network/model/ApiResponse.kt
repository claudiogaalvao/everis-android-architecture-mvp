package br.com.everis.androidmvp.infrastructure.network.model

//TODO: 1 - Mover esta classe para o package model
data class ApiResponse(
    val message: String,
    val number: Int,
    val people : List<People>

)
