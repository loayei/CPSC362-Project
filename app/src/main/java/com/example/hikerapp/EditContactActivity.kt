package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.edit_contact.*

class EditContactActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_contact)
        val number = intent.getStringExtra("phone")
        val user = Firebase.auth.currentUser
        val db = FirebaseFirestore.getInstance()

        val contact = db.collection("users")
            .document(user?.email.toString())
            .collection("contacts").document(number as String)

        saveEditButton.setOnClickListener{
            val fName = fNameCon.text.toString()
            val lName = lNameCon.text.toString()
            val phone = phoneNumberCon.text.toString()

            if(fName.isNotEmpty()){
                contact.update("first", fName)
            }

            if(lName.isNotEmpty()){
                contact.update("last", lName)
            }

            if(phone.isNotEmpty()){
                contact.update("phone", phone)
            }

            val gcActivity = Intent(this, GetContactsActivity::class.java)
            startActivity(gcActivity)
            finish()
        }

        backEditContact.setOnClickListener{
            val clActivity = Intent(this, ContactListActivity::class.java)
            startActivity(clActivity)
            finish()
        }
    }
}