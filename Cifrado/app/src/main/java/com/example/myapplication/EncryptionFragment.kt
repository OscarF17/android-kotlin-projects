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

class EncryptionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_encryption, container, false)
        val text = view.findViewById<EditText>(R.id.encryptText)
        val button = view.findViewById<Button>(R.id.encryptFragmet)
        val display = view.findViewById<TextView>(R.id.showEncrypted)

        display.visibility = View.INVISIBLE

        button.setOnClickListener {
            display.visibility = View.VISIBLE
            val cifrar = text.text.toString()
            val cifrado = cifrarTexto(cifrar)
            display.text = cifrado
        }

        return view
    }

    fun cifrarTexto(texto:String): String {
        var cifrado = ""
        for (i in texto) {
            var original = i
            // Solo transformar letras
            if(i.isLetter()) {
                // Hacer lowecase para facilitar checks
                var letra = i.lowercaseChar()
                // Permitir wraparound
                if (letra == 'z') {
                    letra = 'a'
                } else {
                    letra++
                }
                // No olvidar que pueden ser mayusculas
                if (original.isUpperCase()) {
                    letra = letra.uppercaseChar()
                }
                cifrado += letra.toString()
                // Log.i("LogOscar", letra.toString())
            }
            else {
                cifrado += i.toString()
            }
        }

        return cifrado
    }

}