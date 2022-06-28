package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_classe.*
import kotlinx.android.synthetic.main.activity_page_eleve_button.*

class classe : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classe)
        val user = Firebase.auth.currentUser
        user.let {
            val prof = user!!.displayName
            name_prof.text=prof
        }
        b1.setOnClickListener {
            val intent = Intent(this@classe,userlist::class.java)
            startActivity(intent)
        }
        b2.setOnClickListener{
            val intent = Intent(this@classe,register::class.java)
            startActivity(intent)
        }
        b3.setOnClickListener {

        }
    }
}