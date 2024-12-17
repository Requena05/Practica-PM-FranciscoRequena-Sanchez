package com.example.practica_pm_franciscorequena_sanchez

import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class EstadisticasCalculatronActivity2 : AppCompatActivity() {
    private lateinit var volver: ImageView
    private lateinit var datos: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estadisticas_calculatron2)
        volver = findViewById(R.id.volver)
        volver.setOnClickListener {
            finish()
        }
        datos=findViewById(R.id.lista_estadisticas)
        val sP = getSharedPreferences("Estadisticas", MODE_PRIVATE)
        datos.adapter = EstadisticasAdapter(sP)=String.format("Partinda nº: ${sP.getInt("num_partidas",0)}\nAciertos: ${sP.getInt("Aciertos",0)}\nFallos:${sP.getInt("Fallos",0)}")





    }
}