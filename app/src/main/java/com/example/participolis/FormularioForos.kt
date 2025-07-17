package com.example.participolis


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormularioForos : AppCompatActivity() {

    private lateinit var buttonCancel: Button
    // Declarar variables para los componentes de la vista
    private lateinit var editTextTitle: EditText
    private lateinit var editTextSubject: EditText
    private lateinit var spinnerOptions: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_foros)

        // Buscar el botón de cancelar por su ID
        buttonCancel = findViewById(R.id.buttonCancelar)
        // Inicializar los componentes de la vista
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextSubject = findViewById(R.id.editTextSubject)
        spinnerOptions = findViewById(R.id.spinnerOptions)

        // Establecer un click listener en el botón de cancelar
        buttonCancel.setOnClickListener {
            // Cerrar la actividad actual
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //Log.d("FormularioForo", " clickeada")
            //Toast.makeText(this, "Se pulsó el botón", Toast.LENGTH_SHORT).show()
        }

        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            // Obtener datos del formulario
            val titulo = editTextTitle.text.toString()
            val asunto = editTextSubject.text.toString()
            val opcionSeleccionada = spinnerOptions.selectedItem.toString()

            // Empaquetar los datos para enviar de vuelta al activity principal
            val resultIntent = Intent()
            resultIntent.putExtra("titulo", titulo)
            resultIntent.putExtra("asunto", asunto)
            resultIntent.putExtra("opcion", opcionSeleccionada)

            // Log para visualizar los datos recibidos
            Log.d("FormularioForos", "Datos: $titulo")
            Log.d("FormularioForos", "Datos: $asunto")
            Log.d("FormularioForos", "Datos: $opcionSeleccionada")

            // Establecer el resultado como OK y enviar los datos
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Cerrar la actividad actual
        }
    }
}