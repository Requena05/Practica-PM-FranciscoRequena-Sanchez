package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Jugar_Partidas_CalculatronActivity2 : AppCompatActivity() {
    private lateinit var botonverpartidas: AppCompatButton
    private lateinit var botonajustes: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_jugar_partidas_calculatron2)

        botonverpartidas.setOnClickListener {
        }
        botonajustes.setOnClickListener {
            val intent = Intent(this, AjustesCalculatronActivity2::class.java)
            startActivity(intent)
        }
        //Las sharedPreferences de ajusten tienen que entrar aqui para todo

    }
}