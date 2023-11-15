// 570390 Oscar Luciano Flores Leija

package flores.oscar.examen_final

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemNameEditText = findViewById<EditText>(R.id.itemNameEditText)
        val quantityEditText = findViewById<EditText>(R.id.quantityEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        addButton.setOnClickListener {
            val itemName = itemNameEditText.text.toString()
            val quantity = quantityEditText.text.toString()

            val isValid = ShoppingListUtil.validateShoppingListItem(itemName, quantity)

            if (isValid) {
                messageTextView.text = "Artículo añadido correctamente"
            } else {
                // Cambiar el texto del mensaje por uno de error para que la prueba de UI sepa que hubo error
                messageTextView.text = "Error al agregar producto"
            }
            messageTextView.visibility = View.VISIBLE
        }
    }
}