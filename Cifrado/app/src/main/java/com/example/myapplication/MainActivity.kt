package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.LayoutInflater
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private lateinit var encrypt:Button
    private lateinit var decrypt:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encrypt = findViewById(R.id.button_encrypt)
        decrypt = findViewById(R.id.button_decrypt)

        // Si no hay un estado inicial, desplegar el fragmento de encriptado
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                //agrego el primer fragmento
                .add(R.id.fragment_container, EncryptionFragment())
                .commit()
        }

        encrypt.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EncryptionFragment())
                .commit()
        }

        decrypt.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DecryptionFragmen())
                .commit()
        }

    }
}