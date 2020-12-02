package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class DeleteContactActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val number = intent.getStringExtra("phone")
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser

        db.collection("users")
            .document(user?.email.toString())
            .collection("contacts").document(number as String).delete()

        val gcActivity = Intent(this, GetContactsActivity::class.java)
        startActivity(gcActivity)
        finish()
    }
}