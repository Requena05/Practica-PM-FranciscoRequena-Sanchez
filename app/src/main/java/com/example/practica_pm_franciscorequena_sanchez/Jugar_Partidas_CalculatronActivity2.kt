package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Jugar_Partidas_CalculatronActivity2 : AppCompatActivity() {
    private lateinit var cuentatras: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var volver: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar_partidas_calculatron2)

        cuentatras = findViewById(R.id.contador)
        volver = findViewById(R.id.volver)
        sharedPreferences = getSharedPreferences("Ajustes", MODE_PRIVATE)
        cuentatras.text = sharedPreferences.getString("cuentaatras", "20")
        volver.setOnClickListener {
            finish()
        }
        if (cuentatras.text == "") {
            cuentatras.text = String.format("21")
        }
            var contador: Long = cuentatras.text.toString().toLong()
            var cuentaatras = object : CountDownTimer(contador * 1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    contador--
                    cuentatras.text = String.format(contador.toString())
                }
                override fun onFinish() {

                }

            }
            cuentaatras.start()

            //Las sharedPreferences de ajusten tienen que entrar aqui para todo

        }
    }