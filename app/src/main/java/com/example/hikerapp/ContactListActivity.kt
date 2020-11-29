package com.example.hikerapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.android.synthetic.main.create_contact.*
import kotlinx.android.synthetic.main.edit_contact.*


class ContactListActivity :AppCompatActivity(){
    companion object{
        private val TAG = "ContactListActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        val bundle:Bundle?=intent.extras
        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val cList = mutableListOf<String>()
        val dList = intent.getStringArrayListExtra("list")


        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@ContactListActivity)
            adapter = dList?.let { ListAdapter(this@ContactListActivity, it) }

            //adapter.onItemClick = {

            }
        }
        //backContactActivity.setOnClickListener{
          //  val contactOptions = Intent(this, ContactActivity::class.java)
            //startActivity(contactOptions)
        //}
}