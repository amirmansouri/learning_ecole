package com.example.learning_miss_omayma

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_form_eleve1.*
import kotlinx.android.synthetic.main.activity_form_eleve4.*
import kotlinx.android.synthetic.main.activity_form_eleve4.view.*

class form_eleve_4 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_eleve4)
        next4.setOnClickListener{
            registre()
Toast.makeText(this,"votre hisoite est bien ajouter merci :D",Toast.LENGTH_SHORT).show()
val intent = Intent(this@form_eleve_4,page_eleve_button::class.java)
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
                        if (radio1.tres_bien.isChecked) {
                            child("review").setValue("أعجبتني كثيرا")
                        }
                        if (radio1.moyenne.isChecked) {
                            child("review").setValue("متوسطة")

                        }
                        if (radio1.bien.isChecked) {
                            child("review").setValue("جيدة")
                        }


                        child("autre histoire").setValue(autre.text.toString())
                    }
            }else{
                TODO()

            }            }
    }
}