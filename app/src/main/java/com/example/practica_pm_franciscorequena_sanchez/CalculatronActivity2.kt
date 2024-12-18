package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class CalculatronActivity2 : AppCompatActivity() {
    private lateinit var botonjugar: AppCompatButton
    private lateinit var botonverestadisticas:AppCompatButton

    private lateinit var botonajustes:AppCompatButton
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sp: SharedPreferences
    private lateinit var volver: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculatron2)

        sharedPreferences = getSharedPreferences("Ajustes", MODE_PRIVATE)
        var operaciones = sharedPreferences.getString("operaciones","")!!.split("|")
        if(operaciones.contains("")) {
            sharedPreferences.edit().putString("operaciones","+|-")!!.apply()
        }
        botonjugar = findViewById(R.id.jugar)
        botonverestadisticas = findViewById(R.id.estadisticas)
        botonajustes = findViewById(R.id.ajustes)
        volver = findViewById(R.id.volver)
        volver.setOnClickListener {
            val intent = Intent(this, SelectorEjerciciosActivity2::class.java)
            startActivity(intent)
        }
        //guardo un 1 en la shared prefrence "uno"

        botonverestadisticas.setOnClickListener {
            val intent = Intent(this, EstadisticasCalculatronActivity2::class.java)
            startActivity(intent)

        }
        botonajustes.setOnClickListener {
            val intent = Intent(this, AjustesCalculatronActivity2::class.java)
            startActivity(intent)
        }
        botonjugar.setOnClickListener {
            val intent = Intent(this, Jugar_Partidas_CalculatronActivity2::class.java)
            startActivity(intent)
        }



    }

}