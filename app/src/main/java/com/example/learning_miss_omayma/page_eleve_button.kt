package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_page_eleve_button.*

class page_eleve_button : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_eleve_button)
        val user = Firebase.auth.currentUser
        user.let {
            val name = user!!.displayName
            name_eleve.text=name
        }
        eleve_b1.setOnClickListener {
            val intent = Intent(this@page_eleve_button,form_eleve_1::class.java)
            startActivity(intent)
        }
    }
}