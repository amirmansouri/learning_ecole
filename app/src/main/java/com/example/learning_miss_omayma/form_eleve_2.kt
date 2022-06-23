package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_form_eleve1.*
import kotlinx.android.synthetic.main.activity_form_eleve2.*

class form_eleve_2 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_eleve2)
        next2.setOnClickListener{
            registre()
            val intent = Intent(this,form_eleve_3::class.java)
            startActivity(intent)
        }
    }


        private fun registre() {

            auth = FirebaseAuth.getInstance()
            database = FirebaseDatabase.getInstance()

            databaseReference = database.reference.child("eleve")

//                    Toast.makeText(this, "EmailRegister", Toast.LENGTH_LONG).show()

            val currentUser = auth.currentUser


            val currentUSerDatabase = databaseReference.child((currentUser?.uid!!)).child("historie")
                .apply {

                    child("temp").setValue(temps.text.toString())
                    child("personnage").setValue(personne.text.toString())
                    child("event").setValue(event.text.toString())
                }



// val d = databaseReference.child(currentUSerDatabase.toString()).apply {
//     child("amir").setValue("salut")
// }
        }

}