package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact.*

class ContactActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact)

        createContactButton.setOnClickListener {
            Log.d("Contact Activity", "Go to create contact")

            val createContact = Intent(this, CreateContactActivity::class.java)
            startActivity(createContact)
        }

        editContactButton.setOnClickListener{
            val editContact = Intent(this, ContactListActivity::class.java)
            startActivity(editContact)
        }

        backMain.setOnClickListener{
            val mainAct = Intent(this, MainActivity::class.java)
            startActivity(mainAct)
        }
    }
}