package com.example.learning_miss_omayma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class register : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val niveau = arrayListOf<String>(
            "السنةالأولى",
            " السنةالثانية",
            "السنةالثالثة",
            "السنةالرابعة",
            "السنةالخامسة",
            "السنةالسادسة"
        )
        val adapter =
            ArrayAdapter(this@register, android.R.layout.simple_spinner_dropdown_item, niveau)
        spinner.adapter = adapter
        registerB.setOnClickListener {
            adduser()

        }


    }


    private fun adduser() {

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference.child("user")
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener {
                val user = FirebaseAuth.getInstance().currentUser
                val profileUpdates =
                    UserProfileChangeRequest.Builder().setDisplayName(name.text.toString()).build()
                user!!.updateProfile(profileUpdates)
                if (it.isSuccessful) {
                    ///set current user

                    ///
                    val text = spinner.selectedItem
                    Toast.makeText(
                        this@register,
                        "${text}",
                        Toast.LENGTH_SHORT
                    ).show()
                    val currentUser = auth.currentUser
                    
                        databaseReference.child(currentUser!!.uid).child((name.text.toString()))
                            .apply {
                                child("email").setValue(email.text.toString())
                                child("name").setValue(name.text.toString())
                                child("niveau").setValue(text)
                            }
                    val intent = Intent(this@register, login_eleve::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText( this , "verifier votre donnees", Toast.LENGTH_SHORT).show()
                }

            }
    }


}