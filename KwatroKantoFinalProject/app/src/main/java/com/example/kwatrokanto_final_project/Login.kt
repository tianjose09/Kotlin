package com.example.kwatrokanto_final_project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {

    private lateinit var signUpButton: Button
    private lateinit var logInButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bind views
        signUpButton = findViewById(R.id.signUpButton)
        logInButton = findViewById(R.id.logInButton)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        logInButton.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val enteredUsername = usernameEditText.text.toString().trim()
        val enteredPassword = passwordEditText.text.toString()

        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val savedUsername = sharedPref.getString("username", null)
        val savedPassword = sharedPref.getString("password", null)

        if (enteredUsername == savedUsername && enteredPassword == savedPassword) {
            Toast.makeText(this, "Login Successful! Redirecting...", Toast.LENGTH_SHORT).show()

            // ✅ Delay 2 seconds before going to MenuPage
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MenuPage::class.java))
                finish()
            }, 2000)

        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}
