package com.example.hikerapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.android.synthetic.main.create_contact.*
import kotlinx.android.synthetic.main.edit_contact.*
import kotlinx.android.synthetic.main.edit_contact.fNameCon
import kotlinx.android.synthetic.main.edit_contact.lNameCon
import kotlinx.android.synthetic.main.edit_contact.phoneNumberCon


class ContactListActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val cList = mutableListOf<String>()

        db.collection("users")
            .document(user?.email.toString())
            .collection("contacts")
            .get().addOnSuccessListener {
                    documents ->
                for(document in documents){
                    val a = document.get("first")
                    val b = document.get("last")
                    val c = "$a $b"
                    cList.add(c)
                }
            }

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@ContactListActivity)
            adapter = ListAdapter(cList)

            //adapter.onItemClick = {

            }
        }
        //backContactActivity.setOnClickListener{
          //  val contactOptions = Intent(this, ContactActivity::class.java)
            //startActivity(contactOptions)
        //}

}