package com.example.kwatrokanto_final_project

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuPage : AppCompatActivity() {

    private lateinit var profileBtn: ImageButton
    private lateinit var headOne: TextView
    private lateinit var headTwo: TextView
    private lateinit var emoBg: ImageView
    private lateinit var happyEmoji: ImageView
    private lateinit var sadEmoji: ImageView
    private lateinit var angryEmoji: ImageView
    private lateinit var disgustedEmoji: ImageView
    private lateinit var scaredEmoji: ImageView
    private lateinit var searchContainer: ConstraintLayout
    private lateinit var searchBtn: ImageButton
    private lateinit var searchEditText: EditText
    private lateinit var addBtn: ImageButton
    private lateinit var diaryPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_page)

        profileBtn = findViewById(R.id.profile)
        headOne = findViewById(R.id.headOne)
        headTwo = findViewById(R.id.headTwo)
        emoBg = findViewById(R.id.emo_bg)
        happyEmoji = findViewById(R.id.happy)
        sadEmoji = findViewById(R.id.sad)
        angryEmoji = findViewById(R.id.angry)
        disgustedEmoji = findViewById(R.id.disgusted)
        scaredEmoji = findViewById(R.id.scared)
        searchContainer = findViewById(R.id.search_container)
        searchBtn = findViewById(R.id.btn_search)
        searchEditText = findViewById(R.id.search)
        addBtn = findViewById(R.id.add)
        diaryPage = findViewById(R.id.diaryPage)

        profileBtn.setOnClickListener {
        }

        happyEmoji.setOnClickListener {
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}