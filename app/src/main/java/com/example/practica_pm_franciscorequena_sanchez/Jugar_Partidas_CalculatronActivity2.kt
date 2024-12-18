package com.example.practica_pm_franciscorequena_sanchez

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.animation.core.animate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class Jugar_Partidas_CalculatronActivity2 : AppCompatActivity() {
    private lateinit var cuentatras: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var cuenta_actual: TextView
    private lateinit var cuenta_anterior: TextView
    private lateinit var cuenta_siguiente: TextView
    private lateinit var aciertos: TextView
    private lateinit var fallidos: TextView
    private lateinit var volver: ImageView
    private lateinit var uno: TextView
    private lateinit var dos: TextView
    private lateinit var tres: TextView
    private lateinit var cuatro: TextView
    private lateinit var cinco: TextView
    private lateinit var seis: TextView
    private lateinit var siete: TextView
    private lateinit var ocho: TextView
    private lateinit var nueve: TextView
    private lateinit var cero: TextView
    private lateinit var igual: TextView
    private lateinit var C: TextView
    private lateinit var CE: TextView
    private var random: Int = 0
    private var random2: Int = 0
    private var cuenta = ""
    private var acierto = 0
    private var fallos = 0
    private var resultado = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar_partidas_calculatron2)
        val sP = getSharedPreferences("Estadisticas", MODE_PRIVATE)

        cuenta_actual = findViewById(R.id.cuenta_actual);cuenta_anterior =
            findViewById(R.id.cuenta_anterior)
        cuenta_siguiente = findViewById(R.id.cuenta_siguiente);
        cuentatras = findViewById(R.id.contador);volver = findViewById(R.id.volver);uno =
            findViewById(R.id.uno)
        dos = findViewById(R.id.dos);tres = findViewById(R.id.tres);cero = findViewById(R.id.cero)
        igual = findViewById(R.id.igual);C = findViewById(R.id.c);CE = findViewById(R.id.ce)
        cuatro = findViewById(R.id.cuatro);cinco = findViewById(R.id.cinco);seis =
            findViewById(R.id.seis)
        siete = findViewById(R.id.siete);ocho = findViewById(R.id.ocho);nueve =
            findViewById(R.id.nueve)
        aciertos = findViewById(R.id.aciertos);fallidos = findViewById(R.id.fallidos)

        sharedPreferences = getSharedPreferences("Ajustes", MODE_PRIVATE)
        var operaciones = sharedPreferences.getString("operaciones", "")!!.split("|")
        cuentatras.text = sharedPreferences.getString("cuentaatras", "21")
        //parte de las animaciones
        val animacion = sharedPreferences.getString("animacion", "Ninguna").toString()
        when (animacion) {
            "Movimiento" -> {
                //mover el contador a la izquierda y a la derecha
                val propertyValuesHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, -100f, 100f)
                val propertyValuesHolder2 = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -10f, 40f,40f,-10f)
                val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(cuentatras, propertyValuesHolder, propertyValuesHolder2)
                objectAnimator.duration = 2000
                objectAnimator.repeatCount = ValueAnimator.INFINITE
                objectAnimator.repeatMode = ValueAnimator.REVERSE
                objectAnimator.start()

            }
            "Estirar cuenta"->{
                //en esta animacion la cuenta actual se hace mas ancha y se hace mas pequeña
                val propertyValuesHolder = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f)
                val propertyValuesHolder2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f)
                val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(cuenta_actual, propertyValuesHolder, propertyValuesHolder2)
                objectAnimator.duration = 2000
                objectAnimator.repeatCount = ValueAnimator.INFINITE
                objectAnimator.repeatMode = ValueAnimator.REVERSE
                objectAnimator.start()

            }
        }



        random = Random.nextInt(
            sharedPreferences.getInt("minimo", 1),
            sharedPreferences.getInt("maximo", 10)
        )
        random2 = Random.nextInt(
            sharedPreferences.getInt("minimo", 1),
            sharedPreferences.getInt("maximo", 10)
        )

        Log.d("operaciones", sharedPreferences.getString("operaciones", "").toString())
        if (random2 > random) cuenta_actual.text =
            String.format(random2.toString() + operaciones.random() + random.toString() + "=")
        else cuenta_actual.text =
            String.format(random.toString() + operaciones.random() + random2.toString() + "=")
        cuenta = cuenta_actual.text.toString()

        resultado = random + random2
        random = Random.nextInt(
            sharedPreferences.getInt("minimo", 1),
            sharedPreferences.getInt("maximo", 10)
        )
        random2 = Random.nextInt(
            sharedPreferences.getInt("minimo", 1),
            sharedPreferences.getInt("maximo", 10)
        )
        if (random2 > random) cuenta_siguiente.text =
            String.format(random2.toString() + operaciones.random() + random.toString() + "=")
        else cuenta_siguiente.text =
            String.format(random.toString() + operaciones.random() + random2.toString() + "=")



        if (cuentatras.text == "") {
            cuentatras.text = String.format("21")
        }
        //con las shared preferences genero una cuenta con el maximo el minimo y la operacion random que haya elegido el usuario en configuracion
        uno.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "1")
        }
        dos.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "2")
        }
        tres.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "3")
        }
        cuatro.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "4")
        }
        cinco.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "5")
        }
        seis.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "6")
        }
        siete.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "7")
        }
        ocho.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "8")
        }
        nueve.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "9")
        }
        cero.setOnClickListener {
            cuenta_actual.text = String.format(cuenta_actual.text.toString() + "0")
        }
        C.setOnClickListener { cuenta_actual.text = cuenta_actual.text.toString().dropLast(1) }
        CE.setOnClickListener { cuenta_actual.text = cuenta_siguiente.text.toString() }
        igual.setOnClickListener {
            cuenta = cuenta_actual.text.toString()
            Log.d("cuenta", cuenta)
            cuenta = cuenta.substringBefore("=")
            //sacamos el array de 3 elementos con la cuenta
            var numeros = cuenta.split("+", "-", "*")

            Log.d("cuenta", cuenta)
            if (cuenta.contains("+")) resultado = numeros[0].toInt() + numeros[1].toInt()
            if (cuenta.contains("-")) resultado = numeros[0].toInt() - numeros[1].toInt()
            if (cuenta.contains("*")) resultado = numeros[0].toInt() * numeros[1].toInt()
            if (cuenta_actual.text.toString().substringAfter("=") == "") {
                fallos++
                fallidos.text = String.format("$fallos :Falladas")
            } else if (resultado == cuenta_actual.text.toString().substringAfter("=").toInt()) {
                acierto++
                aciertos.text = String.format("Aciertos: $acierto")
                sP.edit().putString("Aciertos", sP.getString("Aciertos", "") + (if (sP.getString("Aciertos", "") == "") "$acierto" else  "$acierto|")).apply()

            } else {
                fallos++
                fallidos.text = String.format("$fallos :Falladas")
                sP.edit().putString("Fallos", sP.getString("Fallos", "") + (if (sP.getString("Fallos", "") == "") "${fallos}allo" else  "|$fallos")).apply()

            }


            cuenta_anterior.text = cuenta_actual.text.toString()
            cuenta_actual.text = cuenta_siguiente.text.toString()
            random = Random.nextInt(
                sharedPreferences.getInt("minimo", 1),
                sharedPreferences.getInt("maximo", 10)
            )
            random2 = Random.nextInt(
                sharedPreferences.getInt("minimo", 1),
                sharedPreferences.getInt("maximo", 10)
            )
            if (random2 > random) cuenta_siguiente.text =
                String.format(random2.toString() + operaciones.random() + random.toString() + "=")
            else cuenta_siguiente.text =
                String.format(random.toString() + operaciones.random() + random2.toString() + "=")
            cuenta = cuenta_siguiente.text.toString()

        }
        volver.setOnClickListener {
            val intent = Intent(this, CalculatronActivity2::class.java)
            startActivity(intent)
        }
        //Cuenta atras
        var contador: Long = cuentatras.text.toString().toLong()
        var cuentaatras = object : CountDownTimer(contador * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                contador--
                cuentatras.text = String.format(contador.toString())
            }

            override fun onFinish() {
                uno.setOnClickListener(null);tres.setOnClickListener(null);cuatro.setOnClickListener(
                    null
                )
                dos.setOnClickListener(null);cinco.setOnClickListener(null);seis.setOnClickListener(
                    null
                )
                siete.setOnClickListener(null);ocho.setOnClickListener(null);nueve.setOnClickListener(
                    null
                )
                cero.setOnClickListener(null);igual.setOnClickListener(null);C.setOnClickListener(
                    null
                );CE.setOnClickListener(null)

                //cojemos el numero de partidas y le sumamos las nuevas

            }
        }
        cuentaatras.start()
    }
}