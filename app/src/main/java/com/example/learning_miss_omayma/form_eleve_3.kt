package com.example.learning_miss_omayma

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_form_eleve1.*
import kotlinx.android.synthetic.main.activity_form_eleve3.*

class form_eleve_3 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_eleve3)
        next3.setOnClickListener{
            registre()
            val intent = Intent(this,form_eleve_4::class.java)
            startActivity(intent)
        }
    }

    private fun registre() {

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        databaseReference = database.reference.child("user")

//                    Toast.makeText(this, "EmailRegister", Toast.LENGTH_LONG).show()

        val user = Firebase.auth.currentUser
        user.let {
            val name_s = user!!.displayName
            Toast.makeText(this, "$name_s", Toast.LENGTH_LONG).show()


            val currentUser = auth.currentUser
            val currentUSerDatabase = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                databaseReference.child("${name_s}").child("historie")
                    .apply {

                        child("resumé").setValue(resume.text.toString())

                    }
            }else{
                TODO()

            }            }



    }


}