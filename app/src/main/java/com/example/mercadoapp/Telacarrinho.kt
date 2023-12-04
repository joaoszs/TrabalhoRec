package com.example.mercadoapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mercadoapp.databinding.ActivityTelacarrinhoBinding
import com.example.mercadoapp.model.ProdutoRepository

class Telacarrinho : AppCompatActivity() {

    private val CONTAINER_FILE = "container_file"
    private val CHAVE_NOME = "nome"
    private val CHAVE_VALOR = "valor"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telacarrinho)

        sharedPreferences = getSharedPreferences(CONTAINER_FILE, Context.MODE_PRIVATE)
        val nomeProdutoDesc = findViewById<TextView>(R.id.Carrinhproduto)
        val ValorProdutoDesc = findViewById<TextView>(R.id.Valorproduto)
        val buttonProdutoDesc = findViewById<Button>(R.id.Buscarendereco)
        val listaProdutoDesc = ProdutoRepository.getProdutos()

        val position = intent.getIntExtra("position", 3)

        if(position < 3){
            val editor = sharedPreferences.edit()
            editor.putString(CHAVE_NOME, listaProdutoDesc[position].nome)
            editor.putString(CHAVE_VALOR, listaProdutoDesc[position].preco.toString())
            editor.apply()

            nomeProdutoDesc.text = sharedPreferences.getString(CHAVE_NOME, "Produto não encontrado")
            ValorProdutoDesc.text = sharedPreferences.getString(CHAVE_VALOR, "Produto não encontrado")
        }else{
            nomeProdutoDesc.text = sharedPreferences.getString(CHAVE_NOME, "Produto não encontrado")
            ValorProdutoDesc.text = sharedPreferences.getString(CHAVE_VALOR, "Produto não encontrado")
        }

        buttonProdutoDesc.setOnClickListener {
            val intent = Intent(this,Telaendereco::class.java)
            startActivity(intent)
        }
    }
}
