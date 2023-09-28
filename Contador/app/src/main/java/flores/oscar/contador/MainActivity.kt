package flores.oscar.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Crear variables para ligar con elementos visuales en el XML
    private lateinit var textView:TextView
    private lateinit var incButton:Button
    private lateinit var resButton:Button
    // Variable contador
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ligar variables de Kotlin con elementos de XML
        textView = findViewById(R.id.textView)
        incButton = findViewById(R.id.increment)
        resButton = findViewById(R.id.restart)

        // Definir acción que realizará el botón cuando le hagan click
        incButton.setOnClickListener {
            // Incrementar contador y actualizar texto
            count++
            textView.text = count.toString()
        }

        resButton.setOnClickListener {
            count = 0
            textView.text = count.toString()
        }

    }
}