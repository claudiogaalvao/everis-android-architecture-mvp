package br.com.everis.androidmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//TODO: 1 - Mover esta classe para o package view
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
