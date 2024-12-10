package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class CalculatronActivity2 : AppCompatActivity() {
    private lateinit var botonjugar: AppCompatButton
    private lateinit var botonverpartidas:AppCompatButton
    private lateinit var botonajustes:AppCompatButton
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculatron2)

        sharedPreferences = getSharedPreferences("mispreferencias", MODE_PRIVATE)
        botonjugar = findViewById(R.id.jugar)
        botonverpartidas = findViewById(R.id.verpartidas)
        botonajustes = findViewById(R.id.ajustes)
        //guardo un 1 en la shared prefrence "uno"
        sharedPreferences.edit().putInt("uno", 1).apply()

        //lo leo
        var a = sharedPreferences.getInt("uno", 0)

        botonverpartidas.setOnClickListener {
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