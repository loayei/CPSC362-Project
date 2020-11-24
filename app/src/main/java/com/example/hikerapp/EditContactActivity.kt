package com.example.hikerapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
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
        listView.setAdapter(adapter)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                setContentView(R.layout.edit_contact)
                var item = parent?.getItemAtPosition(position)
                item = item.toString()

                saveButton.setOnClickListener {
                    val firstName = fNameCon.text.toString()
                    val lastName = lNameCon.text.toString()
                    val phoneNumber = phoneNumberCon.text.toString()

                    if(firstName.isNotEmpty()){
                        db.collection("users").document(user?.email.toString())
                        .collection("contacts").document(item).update("first", firstName)}

                    if(lastName.isNotEmpty()){
                        db.collection("users").document(user?.email.toString())
                            .collection("contacts").document(item).update("last", lastName)}

                    if(phoneNumber.isNotEmpty()){
                        db.collection("users").document(user?.email.toString())
                            .collection("contacts").document(item).update("phone", phoneNumber)}
                }
            }
        }
    }
}