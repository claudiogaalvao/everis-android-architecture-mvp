package br.com.everis.androidmvp.infrastructure.network.model

data class ApiResponse(
    val message: String,
    val number: Int,
    val people : List<People>

)
