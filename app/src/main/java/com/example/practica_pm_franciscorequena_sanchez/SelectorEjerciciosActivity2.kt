package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SelectorEjerciciosActivity2 : AppCompatActivity() {
    private lateinit var ejecicio1: ImageButton
    private lateinit var ejecicio2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selector_ejercicios2)
        ejecicio1=findViewById(R.id.MemoryTron)
        ejecicio2=findViewById(R.id.CalculaTron)

        ejecicio1.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        ejecicio2.setOnClickListener{
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }

    }
}