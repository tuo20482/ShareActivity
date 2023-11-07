package edu.temple.funwithintents

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
            startActivity(
                Intent.createChooser(Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, editText.toString())
                    type = "text/plain"
                }, null)
            )
        }
    }
}