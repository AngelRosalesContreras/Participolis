package com.example.participolis

import MenuAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomFragmentDirectorio : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_directorio, container, false)
        val recyclerViewMenu: RecyclerView = rootView.findViewById(R.id.recyclerViewMenu)

        val menuItems = listOf(
            MenuItem(R.drawable.lugar, "Coliseo de Roma"),
            MenuItem(R.drawable.lg2, "Chichén Itzá"),
            MenuItem(R.drawable.lg3, "Ek Balam"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 4"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 5"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 6"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 7"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 8"),
            MenuItem(R.drawable.lugar, "Nombre del Lugar 9")
            // Agrega más elementos del menú según sea necesario
        )

        val adapter = MenuAdapter(requireContext(), menuItems)
        recyclerViewMenu.adapter = adapter
        recyclerViewMenu.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }
}