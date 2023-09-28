package alanis.jorge.quiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var MensajeTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        MensajeTextView = findViewById(R.id.textView)

        trueButton.setOnClickListener{
            //do something
            Toast.makeText(this,R.string.correct_toast, Toast.LENGTH_SHORT).show()
            MensajeTextView.text = resources.getString(R.string.correct_toast)
        }

        falseButton.setOnClickListener{
            //do something
            Toast.makeText(this,R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
            MensajeTextView.text = resources.getString(R.string.question_text)
        }

    }
}