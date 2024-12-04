package com.example.practica_pm_franciscorequena_sanchez

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var carta1: ImageView ;private lateinit var carta2: ImageView ;private lateinit var carta3: ImageView
    private lateinit var carta4: ImageView ;private lateinit var carta5: ImageView ;private lateinit var carta6: ImageView
    private lateinit var carta7: ImageView ;private lateinit var carta8: ImageView ;private lateinit var carta9: ImageView
    private lateinit var carta10: ImageView ;private lateinit var carta11: ImageView ;private lateinit var carta12: ImageView
    private lateinit var vida1: ImageView ;private lateinit var vida2: ImageView ;private lateinit var vida3: ImageView
    private lateinit var vidaperdida: ImageView ;private lateinit var vidaperdida2: ImageView ;private lateinit var vidaperdida3: ImageView
    private lateinit var reiniciar: AppCompatButton;private lateinit var vidas:LinearLayout

    private var idcarta=0
    private val posicion = mutableListOf(1,1,2,2,3,3,4,4,5,5,6,6)
    private var cartasgiradas= mutableListOf(false,false,false,false,false,false,false,false,false,false,false,false)
    private var primera_carta_girada:Int?=null
    private var segunda_carta_girada:Int?=null
    private var fallos=0
    private var ganador=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Parte de definir variables
        carta1=findViewById(R.id.carta1);carta2=findViewById(R.id.carta2)
        carta3=findViewById(R.id.carta3);carta4=findViewById(R.id.carta4)
        carta5=findViewById(R.id.carta5);carta6=findViewById(R.id.carta6)
        carta7=findViewById(R.id.carta7);carta8=findViewById(R.id.carta8)
        carta9=findViewById(R.id.carta9);carta10=findViewById(R.id.carta10)
        carta11=findViewById(R.id.carta11);carta12=findViewById(R.id.carta12)
        vida1=findViewById(R.id.vida1);vida2=findViewById(R.id.vida2)
        vida3=findViewById(R.id.vida3);vidaperdida=findViewById(R.id.vidaperdida1)
        vidaperdida2=findViewById(R.id.vidaperdida2);vidaperdida3=findViewById(R.id.vidaperdida3)
        reiniciar=findViewById(R.id.reiniciar);vidas=findViewById(R.id.vidas)

        //Barajar nuestras cartas
        pareja(posicion)

        carta1.setOnClickListener{flipCard(carta1,posicion[0]);compararcartas();ganar()};carta2.setOnClickListener{flipCard(carta2,posicion[1]);compararcartas();ganar()}
        carta3.setOnClickListener{flipCard(carta3,posicion[2]);compararcartas();ganar()};carta4.setOnClickListener{flipCard(carta4,posicion[3]);compararcartas();ganar()}
        carta5.setOnClickListener{flipCard(carta5,posicion[4]);compararcartas();ganar()};carta6.setOnClickListener{flipCard(carta6,posicion[5]);compararcartas();ganar()}
        carta7.setOnClickListener{flipCard(carta7,posicion[6]);compararcartas();ganar()};carta8.setOnClickListener{flipCard(carta8,posicion[7]);compararcartas();ganar()}
        carta9.setOnClickListener{flipCard(carta9,posicion[8]);compararcartas();ganar()};carta10.setOnClickListener{flipCard(carta10,posicion[9]);compararcartas();ganar()}
        carta11.setOnClickListener{flipCard(carta11,posicion[10]);compararcartas();ganar()};carta12.setOnClickListener{flipCard(carta12,posicion[11]);compararcartas();ganar()}
    }
    fun pareja(barajas:MutableList<Int>){
        barajas.shuffle()}
    private fun flipCardreverse(card: ImageView) {
        card.animate().rotationY(0F).setDuration(1000).start()
        card.setImageResource(R.drawable.carta)
        card.scaleType=ImageView.ScaleType.FIT_XY
    }
    private fun flipCard(card: ImageView,position:Int) {
        idcarta=position
        when(idcarta){
            1->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta1);card.scaleType=ImageView.ScaleType.FIT_XY}
            2->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta2);card.scaleType=ImageView.ScaleType.FIT_XY}
            3->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta3);card.scaleType=ImageView.ScaleType.FIT_XY}
            4->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta4);card.scaleType=ImageView.ScaleType.FIT_XY}
            5->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta5);card.scaleType=ImageView.ScaleType.FIT_XY}
            6->{card.animate().rotationY(360F).setDuration(1000).start();card.setImageResource(R.drawable.carta6);card.scaleType=ImageView.ScaleType.FIT_XY}
        }
    }
    private fun ganar(){
        if(ganador==6){
            Toast.makeText(this, "Has ganado", Toast.LENGTH_SHORT).show()
            reiniciar.visibility=LinearLayout.VISIBLE
            vidas.visibility=LinearLayout.GONE
            reiniciar.setOnClickListener{
                recreate()
            }}
       when(fallos){
           1->{vidaperdida.visibility=ImageView.VISIBLE;vida1.visibility=ImageView.GONE}
           2->{vidaperdida2.visibility=ImageView.VISIBLE;vida2.visibility=ImageView.GONE}
           3->{
               vidaperdida3.visibility=ImageView.VISIBLE;vida3.visibility=ImageView.GONE
               Toast.makeText(this, "Has perdido", Toast.LENGTH_SHORT).show()
               reiniciar.visibility=LinearLayout.VISIBLE
               vidas.visibility=LinearLayout.GONE
               reiniciar.setOnClickListener{
                   recreate()
               }
               carta1.setOnClickListener{flipCardreverse(carta1)};carta2.setOnClickListener{flipCardreverse(carta2)}
               carta3.setOnClickListener{flipCardreverse(carta3)};carta4.setOnClickListener{flipCardreverse(carta4)}
               carta5.setOnClickListener{flipCardreverse(carta5)};carta6.setOnClickListener{flipCardreverse(carta6)}
               carta7.setOnClickListener{flipCardreverse(carta7)};carta8.setOnClickListener{flipCardreverse(carta8)}
               carta9.setOnClickListener{flipCardreverse(carta9)};carta10.setOnClickListener{flipCardreverse(carta10)}
               carta11.setOnClickListener{flipCardreverse(carta11)};carta12.setOnClickListener{flipCardreverse(carta12)}
               carta1.setOnClickListener(null);carta2.setOnClickListener(null);carta3.setOnClickListener(null)
               carta4.setOnClickListener(null);carta5.setOnClickListener(null);carta6.setOnClickListener(null)
               carta7.setOnClickListener(null);carta8.setOnClickListener(null);carta9.setOnClickListener(null)
               carta10.setOnClickListener(null);carta11.setOnClickListener(null);carta12.setOnClickListener(null)
           }

           }
       }






    private fun compararcartas(){
        if(posicion[primera_carta_girada!!]==posicion[segunda_carta_girada!!]){
            cartasgiradas[primera_carta_girada!!]=true
            cartasgiradas[segunda_carta_girada!!]=true
            ganador++
            primera_carta_girada=null
            segunda_carta_girada=null
        }else{
            lifecycleScope.launch {
                when(posicion[primera_carta_girada!!]){
                    1->{flipCardreverse(carta1)}2->{flipCardreverse(carta2)}3->{flipCardreverse(carta3)}
                    4->{flipCardreverse(carta4)}5->{flipCardreverse(carta5)}6->{flipCardreverse(carta6)}
                    7->{flipCardreverse(carta7)}8->{flipCardreverse(carta8)}9->{flipCardreverse(carta9)}
                    10->{flipCardreverse(carta10)}11->{flipCardreverse(carta11)}12->{flipCardreverse(carta12)}
                }
                delay(2000)
                when(posicion[segunda_carta_girada!!]){
                    1->{flipCardreverse(carta1)}2->{flipCardreverse(carta2)}3->{flipCardreverse(carta3)}
                    4->{flipCardreverse(carta4)}5->{flipCardreverse(carta5)}6->{flipCardreverse(carta6)}
                    7->{flipCardreverse(carta7)}8->{flipCardreverse(carta8)}9->{flipCardreverse(carta9)}
                    10->{flipCardreverse(carta10)}11->{flipCardreverse(carta11)}12->{flipCardreverse(carta12)}
                }
            }
            fallos++
            primera_carta_girada=null
            segunda_carta_girada=null
        }
    }
    }

