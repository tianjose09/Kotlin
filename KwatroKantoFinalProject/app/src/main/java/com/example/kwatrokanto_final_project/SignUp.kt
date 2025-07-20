package com.example.kwatrokanto_final_project

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        signUpButton = findViewById(R.id.signUpButton)
        logInButton = findViewById(R.id.logInButton)

        // Login button click
        logInButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        // Signup button click
        signUpButton.setOnClickListener {
            handleSignUp()
        }
    }

    private fun handleSignUp() {
        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        val email = emailEditText.text.toString().trim()

        // Email must contain @
        if (!email.contains("@")) {
            showToast("Please enter a valid email with '@'")
            return
        }

        // Password must be strong
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[!@#\$%^&*(),.?\":{}|<>])(?=.*\\d).{8,}$")
        if (!password.matches(passwordRegex)) {
            showToast("Password must be at least 8 characters and include:\n1 uppercase, 1 special char, 1 number")
            return
        }

        // Passwords must match
        if (password != confirmPassword) {
            showToast("Passwords do not match.")
            return
        }

        // ✅ Save to SharedPreferences
        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("username", username)
            putString("password", password)
            apply()
        }

        // All validation passed
        showToast("Successfully Signed Up!")
        // Navigate or clear form if needed
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
