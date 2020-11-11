package com.example.hikerapp

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.sign_up.*

class RegistrationActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)


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
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d("Registration", "User successfully registered")
                    finish()
                }
                .addOnFailureListener {
                    Log.d("Registration", "Failed to register user")
                    Toast.makeText(this, "Failed to register user: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }




    }


}