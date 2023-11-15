
package alanis.jorge.testingprep

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

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirmPasswordEditText)
        val submitButton = findViewById<Button>(R.id.submitBtn)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            val isValid = RegistrationUtil.validateRegistrationInput(
                username,
                password,
                confirmPassword
            )

            if (isValid) {
                messageTextView.text = "Registro exitoso"
                messageTextView.visibility = View.VISIBLE
            } else {
                messageTextView.text = "Error en el registro"
                messageTextView.visibility = View.VISIBLE
            }
        }
    }
}
