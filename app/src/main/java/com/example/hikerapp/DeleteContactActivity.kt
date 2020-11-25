package com.example.hikerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class DeleteContactActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.delete_contact)

        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val bundle:Bundle? = intent.extras
        val contact = bundle?.get("contact")

        val alertDialog: AlertDialog.Builder = this.let{
            val builder = AlertDialog.Builder(it)
            builder.apply{
                setPositiveButton(R.string.delete){dialog, id ->
                    db.collection("users").document(user?.email.toString())
                        .collection("contacts").document(contact as String).delete()

                    val editContact = Intent(this@DeleteContactActivity, EditContactActivity::class.java)
                    startActivity(editContact)
                }
                setNegativeButton(R.string.cancel){dialog, id ->
                    val editContact = Intent(this@DeleteContactActivity , EditContactActivity::class.java)
                    startActivity(editContact)
                }
            }
        }
    }
}