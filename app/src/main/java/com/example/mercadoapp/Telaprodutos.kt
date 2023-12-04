package com.example.mercadoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.mercadoapp.adapter.produtoadapter
import com.example.mercadoapp.model.ProdutoRepository


class Telaprodutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telaprodutos)

        val listViewTelaDois = findViewById<ListView>(R.id.Listaprodutos)

        listViewTelaDois.adapter = produtoadapter(this, ProdutoRepository.getProdutos())

        listViewTelaDois.setOnItemClickListener { parent, view, position, id ->
            intent = Intent(this, Teladescricao::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }


    }
}



