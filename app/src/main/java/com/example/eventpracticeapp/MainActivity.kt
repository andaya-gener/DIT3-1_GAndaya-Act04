package com.example.eventpracticeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val ageText = ageInput.text.toString().trim()

            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val age = ageText.toInt()
                    val message = "Hello $name! You are $age years old."
                    resultText.text = message
                    Snackbar.make(submitButton, "Submission successful!", Snackbar.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    // kung may letter o symbol sa age input
                    Toast.makeText(
                        this,
                        "Invalid input! Please enter a valid number for age.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}