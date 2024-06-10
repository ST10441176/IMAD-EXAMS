package com.example.imadexams

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

lass MainActivity2 : AppCompatActivity() {

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

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val screenTime = intent.getIntArrayExtra("screenTime") ?: intArrayOf()
        val categories = intent.getStringArrayExtra("categories") ?: arrayOf()

        val totalScreenTime = screenTime.sum()
        val averageScreenTime = if (screenTime.isNotEmpty()) totalScreenTime / screenTime.size else 0

        findViewById<TextView>(R.id.totalScreenTime).text = "Total Daily Screen Time: $totalScreenTime minutes"
        findViewById<TextView>(R.id.averageScreenTime).text = "Average Screen Time: $averageScreenTime minutes"

        findViewById<Button>(R.id.blockButton).setOnClickListener {
        }
    }
}
