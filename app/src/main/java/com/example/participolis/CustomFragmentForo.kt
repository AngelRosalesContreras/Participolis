package com.example.participolis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.participolis.R

class CustomFragmentForo : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_foro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardCultura: CardView = view.findViewById(R.id.cardCultura)
        val cardSeguridad: CardView = view.findViewById(R.id.cardSeguridad)
        val cardSerPublicos: CardView = view.findViewById(R.id.cardSerPublicos)
        val cardSalud: CardView = view.findViewById(R.id.cardSalud)
        val cardActComunitarias: CardView = view.findViewById(R.id.cardActCominutarias)
        val cardTrabajos: CardView = view.findViewById(R.id.cardSerTrabajos)
        val cardSociales: CardView = view.findViewById(R.id.cardSociales)
        val cardMedioAmbiente: CardView = view.findViewById(R.id.cardMedioAmbiente)


        cardCultura.setOnClickListener {
            //Log.d("CustomFragmentForo", "Card de Cultura clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de cultura", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), CulruraActivity::class.java)
            startActivity(intent)
        }

        cardSeguridad.setOnClickListener {
            //Log.d("CustomFragmentForo", "Card de Seguridad clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de seguridad", Toast.LENGTH_SHORT).show()
            // Aquí puedes iniciar otra actividad si es necesario
        }

        cardSerPublicos.setOnClickListener {
            //Log.d("ForoActivity", "Card de Servicios Públicos clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de servicios públicos", Toast.LENGTH_SHORT).show()
        }

        cardSalud.setOnClickListener {
            //Log.d("ForoActivity", "Card de Salud clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de salud", Toast.LENGTH_SHORT).show()
        }

        cardActComunitarias.setOnClickListener {
            //Log.d("ForoActivity", "Card de Actividades Comunitarias clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de actividades comunitarias", Toast.LENGTH_SHORT).show()
        }

        cardTrabajos.setOnClickListener {
            //Log.d("ForoActivity", "Card de Trabajos clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de trabajos", Toast.LENGTH_SHORT).show()
        }

        cardSociales.setOnClickListener {
            //Log.d("ForoActivity", "Card de Sociales clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de sociales", Toast.LENGTH_SHORT).show()
        }

        cardMedioAmbiente.setOnClickListener {
            //Log.d("ForoActivity", "Card de Medio Ambiente clickeada")
            //Toast.makeText(requireContext(), "Se pulsó la card de medio ambiente", Toast.LENGTH_SHORT).show()
        }

        // Configura los clics para otros CardView según sea necesario
    }

    /*
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.activity_foro, container, false)
        val listViewOtherPosts: ListView = rootView.findViewById(R.id.listViewOtherPosts)
        ForoManager.configurarLista(requireActivity() as AppCompatActivity, listViewOtherPosts)
        return rootView
    }

     */

}