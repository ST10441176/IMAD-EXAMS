package com.example.examsimad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private val screenTime = IntArray(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val MorningInput = findViewById<EditText>(R.id.MorningInput)
        val AfternoonInput = findViewById<EditText>(R.id.AfternoonInput)
        val EveningInput = findViewById<EditText>(R.id.EveningInput)

        findViewById<Button>(R.id.submitButton).setOnClickListener{
            val workTime = MorningInput.text.toString()
            val entertainmentTime = AfternoonInput.text.toString()
            val otherTime = EveningInput.text.toString()

            if (validateInput(workTime) && validateInput(entertainmentTime) && validateInput(otherTime)) {
                screenTime[0] = workTime.toInt()
                screenTime[1] = entertainmentTime.toInt()
                screenTime[2] = otherTime.toInt()
                Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter valid positive numbers for all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.clearButton).setOnClickListener {
            screenTime.fill(0)
            MorningInput.text.clear()
            AfternoonInput.text.clear()
            EveningInput.text.clear()
            Toast.makeText(this, "Data cleared. You can re-enter data.", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.detailedViewButton).setOnClickListener {
            val intent = Intent( this, MainActivity3::class.java).apply {
                putExtra("screenTime", screenTime)
            }
            startActivity(intent)
        }
    }

    private fun validateInput(input:String): Boolean {
        return try {
            val value = input.toInt()
            value > 0
        }  catch (e: NumberFormatException) {
            false
        }
    }
}