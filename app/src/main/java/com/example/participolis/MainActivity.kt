package com.example.participolis

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomNavigationView: BottomNavigationView
    private val REQUEST_CODE_FOROS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab : FloatingActionButton = findViewById(R.id.fab)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar1)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_menu_24)


        // Configurar el evento de clic en el botón de hamburguesa
        toolbar.setNavigationOnClickListener {
            // Abrir o cerrar el cajón de navegación según su estado actual
            if (drawerLayout.isDrawerOpen(navView)) {
                drawerLayout.closeDrawer(navView)
            } else {
                drawerLayout.openDrawer(navView)
            }
        }

        // Manejar el clic de los elementos del menú
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_logout -> {
                    // Aquí maneja el clic del botón logout
                    // Puedes iniciar sesión nuevamente o realizar otras acciones necesarias
                    Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                    true // Devuelve true para indicar que el evento fue manejado
                }
                else -> false // Devuelve false para otros elementos del menú
            }
        }


        fab.setOnClickListener {
            // Crear y mostrar el BottomSheetDialog
            val bottomSheetDialog = BottomSheetDialog(this@MainActivity)
            bottomSheetDialog.setContentView(R.layout.bottomsheelayout)

            // Configurar el botón de cancelar
            val cancelButton = bottomSheetDialog.findViewById<ImageView>(R.id.cancelButton)
            cancelButton?.setOnClickListener {
                bottomSheetDialog.dismiss()
            }

            // Manejar el clic en el botón de foros en el BottomSheetDialog
            val layoutForo = bottomSheetDialog.findViewById<LinearLayout>(R.id.layoutForo)
            layoutForo?.setOnClickListener {
                // Abrir el layout del formulario de foros
                bottomSheetDialog.dismiss() // Cerrar el BottomSheetDialog actual
                //abrirFormularioForos()
                val intent = Intent(this, FormularioForos::class.java)
                startActivityForResult(intent, REQUEST_CODE_FOROS)
            }


            // Mostrar el BottomSheetDialog
            bottomSheetDialog.show()

        }



        // Manejar el evento de clic en los elementos del menú
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Profile -> {
                    // Reemplazar el contenido del FrameLayout con el fragmento personalizado
                    replaceFragment(CustomFragmentForo())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.Home -> {
                    replaceFragment(CustomFragmentHome())
                    return@setOnNavigationItemSelectedListener  true
                }

                R.id.Directorio -> {
                    replaceFragment(CustomFragmentDirectorio())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.Encuestas -> {
                    replaceFragment(CustomFragmentEncuestas())
                    return@setOnNavigationItemSelectedListener true
                }

                // Agrega más casos según sea necesario para otros elementos del menú
                else -> false
            }
        }
    }


    // Asegúrate de cerrar el cajón de navegación si está abierto cuando se presiona el botón Atrás
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navView)) {
            drawerLayout.closeDrawer(navView)
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    private fun abrirFormularioForos() {
        // Abrir el layout del formulario de foros
        // setContentView(R.layout.activity_formulario_foros)
        val intent = Intent(this, FormularioForos::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_FOROS && resultCode == Activity.RESULT_OK) {
            // Obtener los datos enviados desde el activity del formulario
            val titulo = data?.getStringExtra("titulo")
            val asunto = data?.getStringExtra("asunto")
            val opcion = data?.getStringExtra("opcion")

            // Log para visualizar los datos recibidos
            Log.d("MainActivity", "Título: $titulo")
            Log.d("MainActivity", "Asunto: $asunto")
            Log.d("MainActivity", "Opción: $opcion")

            // Hacer algo con los datos, como enviarlos al activity correspondiente
            when (opcion) {
                "Cultura" -> {
                    val intent = Intent(this, CulruraActivity::class.java)
                    intent.putExtra("titulo", titulo)
                    intent.putExtra("asunto", asunto)
                    startActivity(intent)
                }
                // Agregar más casos para otras opciones si es necesario
                else -> {
                    // Manejar otras opciones si es necesario
                }
            }
        }
    }

}