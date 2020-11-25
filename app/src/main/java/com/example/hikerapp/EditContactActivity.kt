package com.example.hikerapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.contact_list.*
import kotlinx.android.synthetic.main.create_contact.*
import kotlinx.android.synthetic.main.edit_contact.*
import kotlinx.android.synthetic.main.edit_contact.fNameCon
import kotlinx.android.synthetic.main.edit_contact.lNameCon
import kotlinx.android.synthetic.main.edit_contact.phoneNumberCon

class EditContactActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_list)
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val cList = arrayListOf<Map<String, Any>>()

        db.collection("users")
                        .document(user?.email.toString())
                        .collection("contacts")
                        .get().addOnSuccessListener {
                    documents ->
                for(document in documents){
                    cList.add(document.data)
                }
            }

        val adapter = ArrayAdapter(this, R.layout.listview_item, cList)

        val listView:ListView = findViewById(R.id.contact_list)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                val alertDialog: AlertDialog? = this.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply{
                        var item = parent?.getItemAtPosition(position)
                        setPositiveButton(R.string.edit) { dialog, id ->
                            //Going to edit contact screen
                            setContentView(R.layout.edit_contact)
                            //var item = parent?.getItemAtPosition(position)

                            saveButton.setOnClickListener {
                                val firstName = fNameCon.text.toString()
                                val lastName = lNameCon.text.toString()
                                val phoneNumber = phoneNumberCon.text.toString()

                                if (firstName.isNotEmpty()) {
                                    db.collection("users").document(user?.email.toString())
                                        .collection("contacts").document(item as String)
                                        .update("first", firstName)
                                }

                                if (lastName.isNotEmpty()) {
                                    db.collection("users").document(user?.email.toString())
                                        .collection("contacts").document(item as String)
                                        .update("last", lastName)
                                }

                                if (phoneNumber.isNotEmpty()) {
                                    db.collection("users").document(user?.email.toString())
                                        .collection("contacts").document(item as String)
                                        .update("phone", phoneNumber)
                                }
                            }

                            backEditContact.setOnClickListener {
                                setContentView(R.layout.contact_list)
                            }
                        }
                        setNegativeButton(R.string.delete) { dialog, id ->
                            val deleteContact = Intent(this@EditContactActivity, DeleteContactActivity::class.java)
                            deleteContact.putExtra("contact", item as String)
                            startActivity(deleteContact)
                        }
                    }
                    builder.create()
                }
            }
        backContactActivity.setOnClickListener{
            val contactOptions = Intent(this, ContactActivity::class.java)
            startActivity(contactOptions)
        }
    }
}