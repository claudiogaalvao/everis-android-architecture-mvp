package br.com.everis.androidmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.everis.androidmvp.R


//DONE: 1 - Mover esta classe para o package view
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
