package com.example.learning_miss_omayma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_eleve.*
import kotlinx.android.synthetic.main.activity_login_eleve.email
import kotlinx.android.synthetic.main.activity_login_eleve.password
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class login_eleve : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_eleve)

        login.setOnClickListener {
            if (checking()) {
                val email = email.text.toString()
                val password = password.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {
                            var intent = Intent(this, form_eleve_1::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // val wrong = getString(R.string.wrong_data)
                            Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                // val detail = getString(R.string.Enter_the_Details)
                Toast.makeText(this, "detail", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checking(): Boolean {
        if (email.text.toString().trim { it <= ' ' }.isNotEmpty()
            && password.text.toString().trim { it <= ' ' }.isNotEmpty()

        ) {
            return true
        }
        return false

    }
}