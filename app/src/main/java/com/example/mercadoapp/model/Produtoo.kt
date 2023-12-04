package com.example.mercadoapp.model

import com.example.mercadoapp.R

data class Produto(
    val id: Int,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val imagem: Int
)

object ProdutoRepository{
    fun getProdutos(): List<Produto>{
        return listOf(
            Produto(
                1,
                "golf",
                "golf gti 300cv",
                110.990,
                R.drawable.golf
            ),
            Produto(
                2,
                "jetta",
                "jetta gli 250cv",
                90.990,
                R.drawable.jetta
            ),
            Produto(
                3,
                "corolla gr",
                "corolla gr 200cv",
                124.250,
                R.drawable.corolla
            )

        )
    }
}