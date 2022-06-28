package com.example.learning_miss_omayma

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import kotlinx.android.synthetic.main.activity_form_eleve1.*

class form_eleve_1 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    var maxid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_eleve1)
        next.setOnClickListener {

            registre()
            val intent = Intent(this, form_eleve_2::class.java)
            startActivity(intent)
        }
    }

    private fun registre() {

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        databaseReference = database.reference.child("user")
        val user = Firebase.auth.currentUser
        user.let {
            val name_s = user!!.displayName
            Toast.makeText(this, "$name_s", Toast.LENGTH_LONG).show()


        val currentUser = auth.currentUser
        val currentUSerDatabase = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            databaseReference.child("${name_s}").child("historie")
                .apply {

                    child("titre").setValue(titre.text.toString())
                    child("ecrivain").setValue(ecrivian.text.toString())
                    child("maison d'édition").setValue(maison.text.toString())
                    child("lieu").setValue(lieu.text.toString())
                }
        } else {
            TODO("VERSION.SDK_INT < R")
        }
    }
    }





//        currentUSerDatabase.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if (snapshot.child("titre").exists())
//                    maxid = (snapshot.childrenCount.toInt())
//                databaseReference.child("historie${maxid + 1}")
//                    .apply {
//                        child("titre").setValue(titre.text.toString())
//                        child("ecrivain").setValue(ecrivian.text.toString())
//                        child("maison d'édition").setValue(maison.text.toString())
//                    }
//                Toast.makeText(this@form_eleve_1, "existe", Toast.LENGTH_SHORT).show()
//
//
//            }
//
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })


// val d = databaseReference.child(currentUSerDatabase.toString()).apply {
//     child("amir").setValue("salut")
// }
    }

