package com.example.participolis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

class InfoLugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_lugares)

        val toolbar: Toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        // Habilitar el botón de regreso en la barra de acción
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        // Obtener el título del MenuItem seleccionado
        val menuItemTitle = intent.getStringExtra("menuItemTitle")
        // Actualizar la vista con el título del MenuItem
        val titleTextView: TextView = findViewById(R.id.textView_title)
        titleTextView.text = menuItemTitle


        // Obtener la referencia de la imagen del Intent
        val menuItemImage = intent.getIntExtra("menuItemImage", 0)
        // Actualizar la vista con la imagen del MenuItem
        val imageViewMain: ImageView = findViewById(R.id.imageView_main)
        imageViewMain.setImageResource(menuItemImage)
    }

    // Agregar el manejo de eventos para el botón de regresar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Regresar a la actividad anterior
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}