package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class GetContactsActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val dList = arrayListOf<String>()
        val pList = arrayListOf<String>()

        dList.clear()
        pList.clear()

        val documents = db.collection("users")
            .document(user?.email.toString())
            .collection("contacts")

        documents.addSnapshotListener{value, e ->
            if(e != null){
                return@addSnapshotListener
            }

            for(doc in value!!){
                val a = doc.getString("first")
                val b = doc.getString("last")
                val c = "$a $b"
                val p = doc.getString("phone")
                dList.add(c)
                if (p != null) {
                    pList.add(p)
                }
            }
            val listLayout = Intent(this, ContactListActivity::class.java)
            listLayout.putExtra("list", dList)
            listLayout.putExtra("phones", pList)
            startActivity(listLayout)
            finish()
        }
    }
}