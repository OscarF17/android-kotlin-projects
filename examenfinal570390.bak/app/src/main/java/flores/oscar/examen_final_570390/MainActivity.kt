

package flores.oscar.examen_final_570390

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        val itemNameEditText = findViewById<EditText>(R.id.itemNameEditText)
        val quantityEditText = findViewById<EditText>(R.id.quantityEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        addButton.setOnClickListener {
            val itemName = itemNameEditText.text.toString()
            val quantity = quantityEditText.text.toString()

            val isValid = true
                //ShoppingListUtil.validateShoppingListItem(itemName, quantity)

            if (isValid) {
                // Aquí podrías agregar la lógica para añadir el artículo a una lista o base de datos
                messageTextView.text = "Artículo añadido correctamente"
            } else {
                messageTextView.text = "Error al añadir el artículo"
            }
            messageTextView.visibility = View.VISIBLE
        }
    }
}