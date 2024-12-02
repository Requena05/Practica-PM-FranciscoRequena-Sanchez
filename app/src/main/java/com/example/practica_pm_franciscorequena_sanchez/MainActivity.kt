package com.example.practica_pm_franciscorequena_sanchez

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var carta1: ImageView
    private lateinit var carta2: ImageView
    private lateinit var carta3: ImageView
    private lateinit var carta4: ImageView
    private lateinit var carta5: ImageView
    private lateinit var carta6: ImageView
    private lateinit var carta7: ImageView
    private lateinit var carta8: ImageView
    private lateinit var carta9: ImageView
    private lateinit var carta10: ImageView
    private lateinit var carta11: ImageView
    private lateinit var carta12: ImageView
    private lateinit var vida1: ImageView
    private lateinit var vida2: ImageView
    private lateinit var vida3: ImageView

     private val lista = mutableListOf(1, 2, 3, 4, 5, 6)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        carta1=findViewById(R.id.carta1)
        carta2=findViewById<ImageView>(R.id.carta2)
        carta3=findViewById<ImageView>(R.id.carta3)
        carta4=findViewById<ImageView>(R.id.carta4)
        carta5=findViewById<ImageView>(R.id.carta5)
        carta6=findViewById<ImageView>(R.id.carta6)
        carta7=findViewById<ImageView>(R.id.carta7)
        carta8=findViewById<ImageView>(R.id.carta8)
        carta9=findViewById<ImageView>(R.id.carta9)
        carta10=findViewById<ImageView>(R.id.carta10)
        carta11=findViewById<ImageView>(R.id.carta11)
        carta12=findViewById<ImageView>(R.id.carta12)
        vida1=findViewById<ImageView>(R.id.vida1)
        vida2=findViewById<ImageView>(R.id.vida2)
        vida3=findViewById<ImageView>(R.id.vida3)

        carta1.setOnClickListener {
            flipCard(carta1)
            pareja(carta1)
        }
        carta2.setOnClickListener {
            flipCard(carta2)
            pareja(carta2)
        }

        carta3.setOnClickListener {
            flipCard(carta3)
            pareja(carta3)
        }
        carta4.setOnClickListener {
            flipCard(carta4)
            pareja(carta4)
        }
        carta5.setOnClickListener {
            flipCard(carta5)
            pareja(carta5)
        }
        carta6.setOnClickListener {
            flipCard(carta6)
            pareja(carta6)
        }
        carta7.setOnClickListener {
            flipCard(carta7)
        }
        carta8.setOnClickListener {
            flipCard(carta8)
        }
        carta9.setOnClickListener {
            flipCard(carta9)
        }
        carta10.setOnClickListener {
            flipCard(carta10)
        }
        carta11.setOnClickListener {
            flipCard(carta11)
        }
        carta12.setOnClickListener {
            flipCard(carta12)

        }


    }
    private fun flipCard(card: ImageView) {
        var random = (1..6).random()

        if(lista[random]==1){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta1)
                card.scaleType=ImageView.ScaleType.FIT_XY


            }
        }
        if(lista[random]==2){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta2)
                card.scaleType=ImageView.ScaleType.FIT_XY}
        }
        if(lista[random]==3){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta3)
                card.scaleType=ImageView.ScaleType.FIT_XY}
        }
        if(lista[random]==4){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta4)
                card.scaleType=ImageView.ScaleType.FIT_XY}
        }
        if(lista[random]==5){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta5)
                card.scaleType=ImageView.ScaleType.FIT_XY}
        }
        if(lista[random]==6){
            if (card.rotationY == 0f) {
                card.animate().rotationY(360F).setDuration(1000).start()
                card.setImageResource(R.drawable.carta6)
                card.scaleType=ImageView.ScaleType.FIT_XY}
        }


    }





    private fun pareja(card: ImageView){

        val parejas = mutableListOf<ImageView>(carta1,carta2,carta3,carta4,carta5,carta6)
        parejas.shuffle()

    }
    private fun ganar(){
        var contador=0


        if(contador==3){
            Toast.makeText(this, "Has Perdido", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Has Ganado", Toast.LENGTH_SHORT).show()
        }
    }
}