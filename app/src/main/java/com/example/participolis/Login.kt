package com.example.participolis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var buttonIn: Button
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var imageViewShowPassword: ImageView

    // Supongamos que estas son las credenciales correctas
    private val username = "root"
    private val password = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonIn = findViewById(R.id.buttonEntrarLogin)
        editTextUsername = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword2)
        imageViewShowPassword = findViewById(R.id.imageViewShowPassword)

        buttonIn.setOnClickListener{
            val inputUsername = editTextUsername.text.toString()
            val inputPassword = editTextPassword.text.toString()

            if (authenticate(inputUsername, inputPassword)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Cierra Activity1
            } else {
                // Mostrar mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }

            /*
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra Activity1*/
        }

        // Agregar funcionalidad para mostrar u ocultar la contraseña
        imageViewShowPassword.setOnClickListener {
            val isPasswordVisible = editTextPassword.transformationMethod == PasswordTransformationMethod.getInstance()
            if (isPasswordVisible) {
                editTextPassword.transformationMethod = null
                imageViewShowPassword.setImageResource(R.drawable.baseline_visibility_off_24) // Cambiar icono a "ocultar"
            } else {
                editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                imageViewShowPassword.setImageResource(R.drawable.baseline_visibility_24) // Cambiar icono a "mostrar"
            }
            editTextPassword.setSelection(editTextPassword.text.length) // Mover cursor al final del texto
        }
    }

    // Método para verificar la autenticación
    private fun authenticate(username: String, password: String): Boolean {
        return username == this.username && password == this.password
    }

}