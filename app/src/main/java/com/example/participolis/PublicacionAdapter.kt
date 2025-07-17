package com.example.participolis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PublicacionAdapter(context: Context, resource: Int, objects: List<Publicacion>) :
    ArrayAdapter<Publicacion>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_publicacion, parent, false)
        }

        val currentPublicacion = getItem(position)

        val imagen = itemView?.findViewById<ImageView>(R.id.imageViewPublicacion)
        val nombre = itemView?.findViewById<TextView>(R.id.textViewNombre)
        val descripcion = itemView?.findViewById<TextView>(R.id.textViewDescripcion)

        imagen?.setImageResource(currentPublicacion?.imagen ?: R.drawable.kayli)
        nombre?.text = currentPublicacion?.nombre
        descripcion?.text = currentPublicacion?.descripcion

        return itemView!!
    }
}
