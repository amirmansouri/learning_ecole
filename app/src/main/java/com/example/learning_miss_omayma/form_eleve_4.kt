package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
                if(radio1.tres_bien.isChecked) {
                    child("review").setValue("أعجبتني كثيرا")
                }
                    if (radio1.moyenne.isChecked){
                        child("review").setValue("متوسطة")

                    }
                    if(radio1.bien.isChecked){
                        child("review").setValue("جيدة")
                    }

                if(radio2.oui.isChecked){
                    child("profité").setValue("إستفدت من أحداثها")
                }
                if(radio2.peut.isChecked){
                    child("profité").setValue("القليل")
                }
                if(radio2.no.isChecked){
                    child("profité").setValue("لم أستفيد")
                }

                child("autre histoire").setValue(autre.text.toString())
            }




    }
}