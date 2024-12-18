package com.example.practica_pm_franciscorequena_sanchez

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_pm_franciscorequena_sanchez.databinding.ActivityEstadisticasCalculatron2Binding

class EstadisticasCalculatronActivity2 : AppCompatActivity() {
    private lateinit var volver: ImageView
    private lateinit var datos: LinearLayout
    private lateinit var binding: ActivityEstadisticasCalculatron2Binding
    private lateinit var listaestadisticas:MutableList<String>
    private lateinit var sP: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstadisticasCalculatron2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        volver = binding.volver
        volver.setOnClickListener {
            val intent = Intent(this, CalculatronActivity2::class.java)
            startActivity(intent)
        }
        datos=binding.listaEstadisticas
         sP = getSharedPreferences("Estadisticas", MODE_PRIVATE)


        listaestadisticas= mutableListOf()
        var stadisticaString = sP.getString("Aciertos","0") + " " + sP.getString("Fallos","0")
        listaestadisticas.add(stadisticaString)

        //con la lista creamos textview y lo añadimos al linearlayout
        Log.d("indices create",listaestadisticas.indices.toString())
        for (i in listaestadisticas.indices){
            val textView = TextView(this)
            textView.text = String.format("Nº partida: "+(i+1)+" \nAciertos:"+listaestadisticas[i].split("|").get(0)+"\n Fallos:"+listaestadisticas[i].split("|").get(1))
            textView.textSize = 20f
            textView.setPadding(10,15,10,15)
            textView.setBackgroundResource(R.drawable.bordesconcolor)
            textView.elevation=5f
            textView.setTextColor(resources.getColor(R.color.black))
            //añadir al textview un margin de 5

//            textView.setFontVariationSettings("'fontFamily' 'sans-serif-thin', 'textFontWeight' '900'" )
            datos.addView(textView)
        }

    }
    override fun onResume() {
        super.onResume()
        Log.d("estadisticas","onResume")

        listaestadisticas= mutableListOf()
        var stadisticaString = sP.getString("Aciertos","0") + " " + sP.getString("Fallos","0")
        listaestadisticas.add(stadisticaString)
        Log.d("indices resume",listaestadisticas.indices.toString())
        for (i in listaestadisticas.indices) {
            val textView = TextView(this)
            textView.text = String.format("Nº partida: "+(i+1)+" \nAciertos:"+listaestadisticas[i].split("|").get(0)+"\n Fallos:"+listaestadisticas[i].split("|").get(1))
            textView.textSize = 20f
            textView.setPadding(10, 15, 10, 15)
            textView.setBackgroundResource(R.drawable.bordesconcolor)
            textView.elevation = 5f
            textView.setTextColor(resources.getColor(R.color.black))
//            textView.setFontVariationSettings("'fontFamily' 'sans-serif-thin', 'textFontWeight' '900'" )
            datos.addView(textView)
        }

    }

}