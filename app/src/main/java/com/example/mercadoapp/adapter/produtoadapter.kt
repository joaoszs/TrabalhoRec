package com.example.mercadoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mercadoapp.R
import com.example.mercadoapp.model.Produto

class produtoadapter(private val context : Context, private val listaprodutos : List<Produto>) : BaseAdapter() {
    override fun getCount(): Int {
        return listaprodutos.size
    }

    override fun getItem(position: Int): Any {
        return listaprodutos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listaproduct, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val produto = getItem(position) as Produto
        viewHolder.imagem.setImageResource(produto.imagem)
        viewHolder.titulo.text = produto.nome

        return view;
    }

    private class ViewHolder(view: View) {
        val imagem: ImageView = view.findViewById(R.id.Imgproduto)
        val titulo: TextView = view.findViewById(R.id.Nomeproduto)
    }
}