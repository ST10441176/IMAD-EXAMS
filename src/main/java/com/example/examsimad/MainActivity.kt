package com.example.examsimad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainscreenButton = findViewById<Button>(R.id.mainscreenButton)
        mainscreenButton.setOnClickListener {
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)

            findViewById<Button>(R.id.exitButton).setOnClickListener {
                finish()
            }

        }
    }
}