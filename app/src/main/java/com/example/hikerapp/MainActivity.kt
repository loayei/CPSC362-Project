package com.example.hikerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            val email = Email_edit_login.text.toString()
            val password = Password_edit_login.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
            }

            Log.d("MainActivity", "Email is: " + email)
            Log.d("MainActivity", "Password: $password")
        }

        signUp_text_login.setOnClickListener {
            Log.d("MainActivity", "Show Registration page")

            val registration = Intent(this, RegistrationActivity::class.java)
            startActivity(registration)
        }
    }
}