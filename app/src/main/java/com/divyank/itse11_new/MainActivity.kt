package com.divyank.itse11_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var sendButton: Button
    lateinit var subjectEditText:EditText
    lateinit var emailEditText :EditText
    lateinit var contentEditText :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendButton = findViewById(R.id.sendButton)
        subjectEditText = findViewById(R.id.subjectEditText)
        emailEditText = findViewById(R.id.emailEditText)
        contentEditText = findViewById(R.id.contentEditText)
        sendButton.setOnClickListener {
            val subject = subjectEditText.text.toString()
            val content = contentEditText.text.toString()
            val email = emailEditText.text.toString()

            // You can implement email sending logic here
            // For example, you can use Intent to open an email client:
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, content)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}