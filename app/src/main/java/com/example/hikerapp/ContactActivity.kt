package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.*

class ContactActivity : AppCompatActivity(){
    override fun onCreate(savedInstance: Bundle?){
        super.onCreate(savedInstance)
        setContentView(R.layout.contact)

        createContactButton.setOnClickListener {
            Log.d("Contact Activity", "Go to create contact")

            val createContact = Intent(this, RegistrationActivity::class.java)
            startActivity(createContact)
        }
    }
}