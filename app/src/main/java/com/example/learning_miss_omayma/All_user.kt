package com.example.learning_miss_omayma

import android.R.array
import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.util.WorkSourceUtil.add
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_all_user.*
import kotlinx.android.synthetic.main.activity_all_user.view.*


class All_user : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_user)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        val currentUser = auth.currentUser

        databaseReference = database.reference.child("user")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
             if(snapshot.exists()){
                 for (usersnapshot in snapshot.children){
                     val disp = Firebase.auth.currentUser
                     disp.let {
                         val dipl = disp!!.displayName

                         Toast.makeText(this@All_user, "$dipl", Toast.LENGTH_LONG).show()

                     }

                 }
             }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }


}