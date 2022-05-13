package br.com.projetoinvest.activity.modelo

data class Renda (
    val valor: Double,
    val prazo: Int,
    val liquidez: Boolean,
    val emissor: Boolean,
    val garantia: Boolean,
    val tributacao: Boolean, //Com ou sem imposto
    val risco: Double,
    val ordenar: Boolean,

        )
