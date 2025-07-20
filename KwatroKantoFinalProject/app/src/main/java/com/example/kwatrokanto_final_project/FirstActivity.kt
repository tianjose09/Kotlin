package com.example.kwatrokanto_final_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var groupName: TextView
    private lateinit var headOne: TextView
    private lateinit var headTwo: TextView
    private lateinit var tapScreen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starter_launch)

        imageView = findViewById(R.id.imageView)
        groupName = findViewById(R.id.groupName)
        headOne = findViewById(R.id.head_one)
        headTwo = findViewById(R.id.head_two)
        tapScreen = findViewById(R.id.tapScreen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rootLayout = findViewById<ConstraintLayout>(R.id.main)
        rootLayout.setOnClickListener {
            val intent = Intent(this, Login::class.java) // Replace with your actual activity
            startActivity(intent)
        }
    }
}