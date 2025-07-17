package com.example.participolis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        button1 = findViewById(R.id.buttonEntrarPrincipal)

        button1.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Cierra Activity1
        }
    }
}