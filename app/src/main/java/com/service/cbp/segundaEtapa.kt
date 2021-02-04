package com.service.cbp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class segundaEtapa : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // TODO mudar o find by ID para binding
        val view =  inflater.inflate(R.layout.fragment_segunda_etapa, container, false)

        val botaoVoltar = view.findViewById<Button>(R.id.segundaEtapa_botaoVoltar)
        botaoVoltar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_segundaEtapa_to_primeiraEtapa)
        }

        return view
    }

}