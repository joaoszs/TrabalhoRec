package com.example.mercadoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mercadoapp.databinding.ActivityTelaenderecoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Telaendereco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telaendereco)

        val InputCepTelaCinco = findViewById<EditText>(R.id.BuscarCep)
        val buttonBuscarCepTelaCinco = findViewById<Button>(R.id.Buscartelaendereco)
        val textViewResultadoTelaCinco = findViewById<TextView>(R.id.Resultadocep)

        buttonBuscarCepTelaCinco.setOnClickListener {
            val cep = InputCepTelaCinco.text.toString().trim()

            if (cep.length == 8) {
                CoroutineScope(Dispatchers.IO).launch {
                    val result: String = buscarEndereco("https://viacep.com.br/ws/${cep}/json/")

                    withContext(Dispatchers.Main) {

                        if (result.isNotEmpty()) {
                            textViewResultadoTelaCinco.text = result
                        } else {
                            textViewResultadoTelaCinco.text = "Cep não encontrado"
                        }
                    }
                }
            }else{
                textViewResultadoTelaCinco.text = "Cep inválido"
            }
        }
    }

    private fun buscarEndereco(urlString: String): String {
        val url = java.net.URL(urlString)
        val connection = url.openConnection() as java.net.HttpURLConnection

        connection.requestMethod = "GET"

        val reader = java.io.BufferedReader(java.io.InputStreamReader(connection.inputStream))
        val response = StringBuilder()
        var line : String? = reader.readLine()

        while(line != null){
            response.append(line)
            line = reader.readLine()
        }
        reader.close()
        connection.disconnect()
        return response.toString()
    }
}




