package com.example.participolis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Encuentas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuentas)

        Log.d("ForoEncuestas", "Card de Sociales clickeada")
    }
}