package com.example.mercadoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mercadoapp.databinding.ActivityTeladescricaoBinding
import com.example.mercadoapp.model.ProdutoRepository

class Teladescricao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teladescricao)

        val imagemProdutoTelaTres = findViewById<ImageView>(R.id.imgdesc)
        val DescricaoProdutoTelaTres = findViewById<TextView>(R.id.Nomedesc)
        val valorProdutoTelaTres = findViewById<TextView>(R.id.textdesc)
        val buttonAdicionarCarrinhoTelaTres = findViewById<Button>(R.id.Botaoadicionar)

        val listaProdutos = ProdutoRepository.getProdutos()

        val position = intent.getIntExtra("position", 0)

        imagemProdutoTelaTres.setImageResource(listaProdutos[position].imagem)
        DescricaoProdutoTelaTres.text = listaProdutos[position].descricao
        valorProdutoTelaTres.text = listaProdutos[position].preco.toString()

        buttonAdicionarCarrinhoTelaTres.setOnClickListener {
            val intent = Intent(this, Telacarrinho::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }


    }
}