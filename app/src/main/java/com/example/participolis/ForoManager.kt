package com.example.participolis

import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
object ForoManager {
    fun configurarLista(activity: AppCompatActivity, listViewOtherPosts: ListView) {
        val publicaciones = listOf(
            Publicacion(R.drawable.kayli, "Usuario1", "Descripción 1"),
            Publicacion(R.drawable.kayli, "Usuario2", "Descripción 2"),
            Publicacion(R.drawable.kayli, "Usuario3", "Descripción 3"),
            Publicacion(R.drawable.kayli, "Usuario4", "Descripción 4"),
            Publicacion(R.drawable.kayli, "Usuario5", "Descripción 5"),
            Publicacion(R.drawable.kayli, "Usuario6", "Descripción 6"),
            Publicacion(R.drawable.kayli, "Usuario7", "Descripción 7"),
            Publicacion(R.drawable.kayli, "Usuario8", "Descripción 8"),
            Publicacion(R.drawable.kayli, "Usuario9", "Descripción 9"),
            Publicacion(R.drawable.kayli, "Usuario10", "Descripción 10"),
            // Agrega más publicaciones según necesites
        )

        val adapter = PublicacionAdapter(activity, R.layout.item_publicacion, publicaciones)
        listViewOtherPosts.adapter = adapter
    }
}*/

object ForoManager {
    // Configurar la publicación del usuario actual en el LinearLayout
    /*fun configurarPublicacionUsuarioActual(activity: AppCompatActivity, imageViewUser: ImageView, textViewUserName: TextView, textViewUserDescription: TextView) {
        // Obtener la publicación del usuario actual (puedes cambiar esto según tu lógica)
        val usuarioActual = Publicacion(R.drawable.kayli, "Usuario Actual", "Descripción del usuario actual")

        // Configurar los elementos de la vista con los datos del usuario actual
        imageViewUser.setImageResource(usuarioActual.imagen)
        textViewUserName.text = usuarioActual.nombre
        textViewUserDescription.text = usuarioActual.descripcion
    }*/

    fun configurarPublicacionUsuarioActual(activity: AppCompatActivity, imageViewUser: ImageView, textViewUserName: TextView, textViewUserDescription: TextView, usuarioActual: Publicacion) {
        // Configurar los elementos de la vista con los datos del usuario actual
        imageViewUser.setImageResource(usuarioActual.imagen)
        textViewUserName.text = usuarioActual.nombre
        textViewUserDescription.text = usuarioActual.descripcion
    }


    // Configurar el ListView con las publicaciones de otros usuarios
    fun configurarLista(activity: AppCompatActivity, listViewOtherPosts: ListView) {
        val publicaciones = listOf(
            Publicacion(R.drawable.kayli, "Alejandro", "Discutamos medidas para mejorar la seguridad en nuestro barrio y cómo prevenir la delincuencia local."),
            Publicacion(R.drawable.kayli, "Valeria", "Compartamos experiencias y soluciones para mejorar la educación en nuestras escuelas locales."),
            Publicacion(R.drawable.kayli, "Ricardo", "¿Cómo podemos fomentar el reciclaje y cuidar nuestro medio ambiente en la comunidad?"),
            Publicacion(R.drawable.kayli, "Mariana", "Debates sobre el transporte público: mejoras, horarios y cómo hacerlo más accesible para todos."),
            Publicacion(R.drawable.kayli, "Guillermo", "Ideas y propuestas para ofrecer actividades recreativas y educativas para los jóvenes de la comunidad."),
            Publicacion(R.drawable.kayli, "Laura", "Discutamos sobre la falta de vivienda, alquileres y soluciones habitacionales en nuestra área."),
            Publicacion(R.drawable.kayli, "Fernando", "Consejos y recursos para mejorar la salud y bienestar de los residentes de nuestra comunidad."),
            Publicacion(R.drawable.kayli, "Gabriela", "Compartamos y celebremos nuestras tradiciones culturales, festivales y eventos locales."),
            Publicacion(R.drawable.kayli, "Diego", "Estrategias para impulsar el crecimiento económico y el empleo en nuestra comunidad."),
            Publicacion(R.drawable.kayli, "Paola", "¿Cómo podemos mejorar el acceso a la tecnología y la conectividad en nuestra comunidad?"),
            Publicacion(R.drawable.kayli, "Carlos", "Propuestas para mejorar y mantener nuestros parques y espacios públicos para el disfrute de todos."),
            Publicacion(R.drawable.kayli, "Isabel", "Ideas para fomentar la integración y la convivencia entre los diferentes grupos de nuestra comunidad."),
            Publicacion(R.drawable.kayli, "Usuario13", "Descripción 13"),
            Publicacion(R.drawable.kayli, "Usuario14", "Descripción 14"),
            // Agrega más publicaciones según necesites
        )

        val adapter = PublicacionAdapter(activity, R.layout.item_publicacion, publicaciones)
        listViewOtherPosts.adapter = adapter
    }
}
