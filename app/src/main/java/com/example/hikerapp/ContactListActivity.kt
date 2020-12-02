package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.android.synthetic.main.create_contact.*
import kotlinx.android.synthetic.main.edit_contact.*


class ContactListActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        val dList = intent.getStringArrayListExtra("list")
        val pList = intent.getStringArrayListExtra("phones")

        recyclerView.apply {

            layoutManager = LinearLayoutManager(this@ContactListActivity)
            if (pList != null) {
                adapter = dList?.let { ListAdapter(this@ContactListActivity, it, pList) }
            }
        }

        backList.setOnClickListener{
            val cActivity = Intent(this, ContactActivity::class.java)
            startActivity(cActivity)
            finish()
        }
    }
}