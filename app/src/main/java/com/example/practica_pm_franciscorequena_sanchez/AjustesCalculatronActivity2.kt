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
    private lateinit var sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("Ajustes", MODE_PRIVATE)
        setContentView(R.layout.activity_ajustes_calculatron2)


        val operaciones=getOperaciones()
        animaciones = findViewById(R.id.animaciones)
        suma = findViewById(R.id.suma)
        resta = findViewById(R.id.Resta)
        multiplicacion = findViewById(R.id.Multiplicacion)
        maximo = findViewById(R.id.maximo)
        minimo = findViewById(R.id.minimo)
        cuentaatras = findViewById(R.id.cuentaatras)
        guardar = findViewById(R.id.guardar)


        for(op in operaciones){
            if(op == "-")resta.isChecked=true
            if(op == "+")suma.isChecked=true
            if(op == "*")multiplicacion.isChecked=true
        }
        //limpiamos sp operaciones
        sharedPreferences.edit().putString("operaciones","").apply()

        val animacion= arrayOf("Ninguna","Animacion1","Animacion2","Animacion3")
        animaciones.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,animacion)
        guardar.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("animacion", animaciones.selectedItem.toString())
            if(maximo.text.toString()==""){
                editor.putInt("maximo",10)
            }else{
                editor.putInt("maximo",maximo.text.toString().toInt())
            }

            if(minimo.text.toString()==""){
                editor.putInt("minimo",1)
            }else{
                editor.putInt("minimo",minimo.text.toString().toInt())
                if (minimo.text.toString().toInt()>maximo.text.toString().toInt()) {
                    minimo.error = "El minimo no puede ser mayor que el maximo"
                    return@setOnClickListener
                }
            }

            if(cuentaatras.text.toString()==""){
                editor.putInt("cuentaatras",21)
            }else{
                editor.putInt("cuentaatras",cuentaatras.text.toString().toInt())
            }

            if (!suma.isChecked && !resta.isChecked && !multiplicacion.isChecked) {
                editor.putString("operaciones", "+|-").apply()
            }
            if (suma.isChecked) {
               // editor.putString("operaciones", sharedPreferences.getString("operaciones", "") + (if (sharedPreferences.getString("operaciones", "") == "") "+" else  "|+"))
                //si ya existe la suma la quitamos no hacemos na y sino la concatenamos

                editor.putString("operaciones", "+").apply()

            }
            if (resta.isChecked) {
                editor.putString("operaciones", sharedPreferences.getString("operaciones", "") + (if (sharedPreferences.getString("operaciones", "") == "") "-" else  "|-")).apply()

            }
            if (multiplicacion.isChecked) {
                editor.putString("operaciones", sharedPreferences.getString("operaciones", "") + (if (sharedPreferences.getString("operaciones", "") == "") "*" else  "|*")).apply()
            }

            editor.putString("cuentaatras", cuentaatras.text.toString())
            editor.apply()
            finish()


        }
    }

    private fun getOperaciones(): List<String> {
        return sharedPreferences.getString("operaciones","")!!.split('|')
    }

}