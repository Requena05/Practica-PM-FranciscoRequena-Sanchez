package com.example.practica_pm_franciscorequena_sanchez

import android.os.Bundle
import android.os.SystemClock
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var carta1: ImageView ;private lateinit var carta2: ImageView ;private lateinit var carta3: ImageView
    private lateinit var carta4: ImageView ;private lateinit var carta5: ImageView ;private lateinit var carta6: ImageView
    private lateinit var carta7: ImageView ;private lateinit var carta8: ImageView ;private lateinit var carta9: ImageView
    private lateinit var carta10: ImageView ;private lateinit var carta11: ImageView ;private lateinit var carta12: ImageView
    private lateinit var vida1: ImageView ;private lateinit var vida2: ImageView ;private lateinit var vida3: ImageView
    private lateinit var vidaperdida: ImageView ;private lateinit var vidaperdida2: ImageView ;private lateinit var vidaperdida3: ImageView
    private lateinit var reiniciar: AppCompatButton;private lateinit var vidas:LinearLayout
    private var contenido=0
    private var idcarta=0
    private var ispareja:Boolean?=false
    private var vidaextra=0
    private val posicion=mutableListOf(1,1,2,2,3,3,4,4,5,5,6,6)
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
        carta1.setOnClickListener{contenido=0;compararpareja();ganar()}
        carta2.setOnClickListener{contenido=1;compararpareja();ganar()}
        carta3.setOnClickListener{contenido=2;compararpareja();ganar()}
        ;carta4.setOnClickListener{contenido=3;compararpareja();ganar()}
        carta5.setOnClickListener{contenido=4;compararpareja();ganar()}
        carta6.setOnClickListener{contenido=5;compararpareja();ganar()}
        carta7.setOnClickListener{contenido=6;compararpareja();ganar()}
        carta8.setOnClickListener{contenido=7;compararpareja();ganar()}
        carta9.setOnClickListener{contenido=8;compararpareja();ganar()}
        carta10.setOnClickListener{contenido=9;compararpareja();ganar()}
        carta11.setOnClickListener{contenido=10;compararpareja();ganar()}
        carta12.setOnClickListener{contenido=11;compararpareja();ganar()}

    }
    override fun onResume() {
        super.onResume()
        SystemClock.sleep(1000)
    }

    fun pareja(barajas:MutableList<Int>){
        barajas.shuffle()}

    private fun flipCardreverse(card: ImageView,position:Int) {
        idcarta=position
        card.animate().rotationY(180F).setDuration(500).start();
        card.setImageResource(R.drawable.carta);card.scaleType=ImageView.ScaleType.FIT_XY


    }
    private fun flipCard(card: ImageView,position:Int) {
        idcarta=position
        if (card.rotationY == 0F){
            when(idcarta){
                1->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta1);card.scaleType=ImageView.ScaleType.FIT_XY}
                2->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta2);card.scaleType=ImageView.ScaleType.FIT_XY}
                3->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta3);card.scaleType=ImageView.ScaleType.FIT_XY}
                4->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta4);card.scaleType=ImageView.ScaleType.FIT_XY}
                5->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta5);card.scaleType=ImageView.ScaleType.FIT_XY}
                6->{card.animate().rotationY(180F).setDuration(500).start();card.setImageResource(R.drawable.carta6);card.scaleType=ImageView.ScaleType.FIT_XY}
            }
        }else{
        when(idcarta){
            1->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta1);card.scaleType=ImageView.ScaleType.FIT_XY}
            2->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta2);card.scaleType=ImageView.ScaleType.FIT_XY}
            3->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta3);card.scaleType=ImageView.ScaleType.FIT_XY}
            4->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta4);card.scaleType=ImageView.ScaleType.FIT_XY}
            5->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta5);card.scaleType=ImageView.ScaleType.FIT_XY}
            6->{card.animate().rotationY(360F).setDuration(500).start();card.setImageResource(R.drawable.carta6);card.scaleType=ImageView.ScaleType.FIT_XY}
        }}
    }
    private fun checkclick(){
        if(primera_carta_girada==null){
            primera_carta_girada=posicion[contenido]
        }else{
            segunda_carta_girada=posicion[contenido]
        }
    }

    private fun compararpareja() {
        checkclick()
        when(contenido){
            0->flipCard(carta1,posicion[0]);1->flipCard(carta2,posicion[1]);2->flipCard(carta3,posicion[2])
            3->flipCard(carta4,posicion[3]);4->flipCard(carta5,posicion[4]);5->flipCard(carta6,posicion[5])
            6->flipCard(carta7,posicion[6]);7->flipCard(carta8,posicion[7]);8->flipCard(carta9,posicion[8])
            9->flipCard(carta10,posicion[9]);10->flipCard(carta11,posicion[10]);11->flipCard(carta12,posicion[11])
        }
       if(primera_carta_girada!=null && segunda_carta_girada!=null){
           if (primera_carta_girada!! == segunda_carta_girada!!) {
               if(!cartasgiradas[primera_carta_girada!!] && !cartasgiradas[segunda_carta_girada!!]
                   && cartasgiradas[primera_carta_girada!!]!=cartasgiradas[segunda_carta_girada!!]){
                   ganador++
                   cartasgiradas[primera_carta_girada!!] =true
                   cartasgiradas[segunda_carta_girada!!] =true
                   }
               primera_carta_girada=null
               segunda_carta_girada=null
           }else{

               guardarcartas()
               fallos++
               primera_carta_girada=null
               segunda_carta_girada=null
           }
       }
    }

private fun guardarcartas(){

    flipCardreverse(carta1,posicion[0]);flipCardreverse(carta2,posicion[1]);flipCardreverse(carta3,posicion[2])
    flipCardreverse(carta4,posicion[3]);flipCardreverse(carta5,posicion[4]);flipCardreverse(carta6,posicion[5])
    flipCardreverse(carta7,posicion[6]);flipCardreverse(carta8,posicion[7]);flipCardreverse(carta9,posicion[8])
    flipCardreverse(carta10,posicion[9]);flipCardreverse(carta11,posicion[10]);flipCardreverse(carta12,posicion[11])
}



    private fun ganar(){
        if(ganador==6){
            Toast.makeText(this, "Has ganado", Toast.LENGTH_SHORT).show()
            reiniciar.visibility=LinearLayout.VISIBLE
            vidas.visibility=LinearLayout.GONE
            reiniciar.setOnClickListener{
                recreate()
            }
        }
        when(fallos){

            1->{vidaperdida.visibility=ImageView.VISIBLE;vida1.visibility=ImageView.GONE
            }
            2->{vidaperdida2.visibility=ImageView.VISIBLE;vida2.visibility=ImageView.GONE
            }
            3->{
                vidaperdida3.visibility=ImageView.VISIBLE;vida3.visibility=ImageView.GONE
                Toast.makeText(this, "Has perdido", Toast.LENGTH_SHORT).show()
                reiniciar.visibility=LinearLayout.VISIBLE
                vidas.visibility=LinearLayout.GONE
                reiniciar.setOnClickListener{
                    recreate()
                }
                flipCardreverse(carta1,posicion[0]);flipCardreverse(carta2,posicion[1]);flipCardreverse(carta3,posicion[2])
                flipCardreverse(carta4,posicion[3]);flipCardreverse(carta5,posicion[4]);flipCardreverse(carta6,posicion[5])
                flipCardreverse(carta7,posicion[6]);flipCardreverse(carta8,posicion[7]);flipCardreverse(carta9,posicion[8])
                flipCardreverse(carta10,posicion[9]);flipCardreverse(carta11,posicion[10]);flipCardreverse(carta12,posicion[11])
                 carta1.setOnClickListener(null);carta2.setOnClickListener(null);carta3.setOnClickListener(null)
                carta4.setOnClickListener(null);carta5.setOnClickListener(null);carta6.setOnClickListener(null)
                carta7.setOnClickListener(null);carta8.setOnClickListener(null);carta9.setOnClickListener(null)
                carta10.setOnClickListener(null);carta11.setOnClickListener(null);carta12.setOnClickListener(null)
            }

        }

    }
}

