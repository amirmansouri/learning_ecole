package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page1.*

class page_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page1)
        maitre.setOnClickListener{}
        eleve.setOnClickListener {
            val intent = Intent(this@page_1,login_eleve::class.java)
            startActivity(intent)
        }
    }
}