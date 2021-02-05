package com.service.cbp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class primeiraEtapa : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // TODO mudar o find by ID para binding
        return  inflater.inflate(R.layout.fragment_primeira_etapa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val botaoContinuar = view.findViewById<Button>(R.id.primeiraEtapa_botaoContinuar)
        botaoContinuar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_primeiraEtapa_to_segundaEtapa)
        }

    }

}