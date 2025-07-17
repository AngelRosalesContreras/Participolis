package com.example.participolis

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CulruraActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: CulturaAdapter
    private val items = mutableListOf<Pair<String, String>>()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culrura)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar3)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        listView = findViewById(R.id.listView)
        sharedPreferences = getSharedPreferences("CulturaPrefs", Context.MODE_PRIVATE)

        // Cargar datos guardados
        loadSavedData()

        // Crear un adaptador para la lista
        adapter = CulturaAdapter(this, items)
        listView.adapter = adapter

        // Obtener datos del intent
        val titulo = intent.getStringExtra("titulo")
        val asunto = intent.getStringExtra("asunto")

        // Asegurarse de que los datos no sean nulos antes de agregarlos a la lista
        if (!titulo.isNullOrEmpty() && !asunto.isNullOrEmpty()) {
            val newItem = Pair(titulo, asunto)
            items.add(newItem)
            saveData(newItem)
            adapter.notifyDataSetChanged()
        } else {
            // Manejar el caso en que los datos sean nulos
            adapter.notifyDataSetChanged()
        }
    }

    private fun saveData(item: Pair<String, String>) {
        val editor = sharedPreferences.edit()
        val currentItems = sharedPreferences.getStringSet("items", mutableSetOf())
        currentItems?.add("${item.first}|${item.second}")
        editor.putStringSet("items", currentItems)
        editor.apply()
    }

    private fun loadSavedData() {
        val savedItems = sharedPreferences.getStringSet("items", mutableSetOf())
        if (!savedItems.isNullOrEmpty()) {
            for (item in savedItems) {
                val parts = item.split("|")
                if (parts.size == 2) {
                    items.add(Pair(parts[0], parts[1]))
                }
            }
        }
    }
}
