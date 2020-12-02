package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.create_contact.*

class CreateContactActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_contact)
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser

        createContactButton.setOnClickListener {
            val firstName = fNameCon.text.toString()
            val lastName = lNameCon.text.toString()
            val phoneNumber = phoneNumberCon.text.toString()

            if (firstName.isEmpty() || phoneNumber.isEmpty()){
                Toast.makeText(this, "Please complete all major fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val contact = hashMapOf(
                "first" to firstName,
                "last" to lastName,
                "phone" to phoneNumber
            )
            
            db.collection("users").document(user?.email.toString())
                .collection("contacts").document(phoneNumber).set(contact)

            val contactActivity = Intent(this, GetContactsActivity::class.java)
            startActivity(contactActivity)
            finish()
        }
        backCreateContact.setOnClickListener{
            val contactActivity = Intent(this, ContactActivity::class.java)
            startActivity(contactActivity)
            finish()
        }
    }
}