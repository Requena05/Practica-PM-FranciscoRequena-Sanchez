package com.example.practica_pm_franciscorequena_sanchez

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class AjustesCalculatronActivity2 : AppCompatActivity() {
    private lateinit var animaciones: Spinner
    private lateinit var suma: CheckBox
    private lateinit var resta: CheckBox
    private lateinit var multiplicacion: CheckBox
    private lateinit var maximo: TextInputEditText
    private lateinit var minimo: TextInputEditText
    private lateinit var cuentaatras: TextInputEditText
    private lateinit var guardar: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ajustes_calculatron2)
        animaciones = findViewById(R.id.animaciones)
        suma = findViewById(R.id.suma)
        resta = findViewById(R.id.Resta)
        multiplicacion = findViewById(R.id.Multiplicacion)
        maximo = findViewById(R.id.maximo)
        minimo = findViewById(R.id.minimo)
        cuentaatras = findViewById(R.id.cuentaatras)
        guardar = findViewById(R.id.guardar)

        val animacion= arrayOf("Ninguna","Animacion1","Animacion2","Animacion3")
        animaciones.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,animacion)
        guardar.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Ajustes", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("animacion", animaciones.selectedItem.toString())
            editor.putBoolean("suma", suma.isChecked)
            editor.putBoolean("resta", resta.isChecked)
            editor.putBoolean("multiplicacion", multiplicacion.isChecked)
            editor.putString("maximo", maximo.text.toString())
            editor.putString("minimo", minimo.text.toString())
            editor.putString("cuentaatras", cuentaatras.text.toString())
            editor.apply()
            finish()


        }
    }

}