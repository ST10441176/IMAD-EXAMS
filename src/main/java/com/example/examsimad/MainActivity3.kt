package com.example.examsimad

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val screenTime = intent.getIntArrayExtra("screenTime") ?: intArrayOf()
        intent.getStringArrayExtra("categories") ?: arrayOf()

        val totalScreenTime = screenTime.sum()
        val averageScreenTime = if (screenTime.isNotEmpty()) totalScreenTime / screenTime.size else 0

        findViewById<TextView>(R.id.totalScreenTime).text = "Total Daily Screen Time: $totalScreenTime minutes"
        findViewById<TextView>(R.id.averageScreenTime).text = "Average Screen Time: $averageScreenTime minutes"

        findViewById<Button>(R.id.blockButton).setOnClickListener {
        }
    }
}