package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DecryptionFragmen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_decryption, container, false)
        val text = view.findViewById<EditText>(R.id.decryptText)
        val button = view.findViewById<Button>(R.id.decryptFragment)
        val display = view.findViewById<TextView>(R.id.showDecrypted)

        display.visibility = View.INVISIBLE

        button.setOnClickListener {
            display.visibility = View.VISIBLE
            val decifrar = text.text.toString()
            val decifrado = decifrarTexto(decifrar)
            display.text = decifrado
        }

        return view
    }

    fun decifrarTexto(texto: String): String {
        var decifrado = ""
        for (i in texto) {
            var original = i
            // Solo transformar letras
            if(i.isLetter()) {
                // Hacer lowecase para facilitar checks
                var letra = i.lowercaseChar()
                // Permitir wraparound
                if (letra == 'a') {
                    letra = 'z'
                } else {
                    letra--
                }
                // No olvidar que pueden ser mayusculas
                if (original.isUpperCase()) {
                    letra = letra.uppercaseChar()
                }
                decifrado += letra.toString()
                // Log.i("LogOscar", letra.toString())
            }
            else {
                decifrado += i.toString()
            }
        }

        return decifrado
    }

}