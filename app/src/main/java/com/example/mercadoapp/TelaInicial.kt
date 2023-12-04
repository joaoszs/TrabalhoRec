package com.example.mercadoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class TelaInicial  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        val ButtonListarProdutos = findViewById<Button>(R.id.Botaoproduto);
        val ButtonMeuCarrinho = findViewById<Button>(R.id.Botaocarrinho);

        ButtonListarProdutos.setOnClickListener {
            val intent = Intent(this, Telaprodutos::class.java)
            startActivity(intent)
        }

        ButtonMeuCarrinho.setOnClickListener {
            val intent = Intent(this, Telacarrinho::class.java)
            startActivity(intent)

        }
    }
}





