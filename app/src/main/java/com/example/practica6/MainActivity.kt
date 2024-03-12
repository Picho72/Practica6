package com.example.practica6

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val lugares = arrayOf("Tequila", "Magdalena", "Talpa", "Naucalpan", "Tepito", "Tala",
    "Guadalajara", "Monterrey", "Zacatecas", "Oaxaca", "Tangamandapio", "El Grullo", "Tapalpa")
    lateinit var txtText: TextView
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtText = findViewById(R.id.txtTexto)
        listView = findViewById(R.id.listaLugares)
        val adaptador = ArrayAdapter(this, R.layout.list_item, lugares)
        listView.adapter = adaptador

        listView.onItemClickListener =
        object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val valor = listView.getItemAtPosition(position) as String
                Log.e("List App", "Valor $valor")
                Toast.makeText(applicationContext, "Valor $valor", Toast.LENGTH_LONG).show()
                txtText.text = valor
            }

        }
    }
}