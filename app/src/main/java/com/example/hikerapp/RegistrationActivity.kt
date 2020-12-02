package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.sign_up.*

class RegistrationActivity : AppCompatActivity(){

    companion object{
        private val TAG = "RegistrationActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        val db = FirebaseFirestore.getInstance()

        signUpButton.setOnClickListener{
            val firstName = FName_signup.text.toString()
            val lastName = LName_signup.text.toString()
            val phoneNo = phNo_signup.text.toString()
            val email = Email_signup.text.toString()
            val password = Password_signup.text.toString()

            if (email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNo.isEmpty()){
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Firebase Authentication
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    val main = Intent(this, MainActivity::class.java)
                    startActivity(main)
                    finish()
                }

            val user = hashMapOf(
                "first" to firstName,
                "last" to lastName,
                "phone" to phoneNo,
                "email" to email,
                "password" to password
            )

            db.collection("users").document(email)
                .set(user)
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written") }
                .addOnFailureListener{ e -> Log.w(TAG, "Error writing document", e)}
        }




    }


}