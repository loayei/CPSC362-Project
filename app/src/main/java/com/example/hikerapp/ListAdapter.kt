package com.example.hikerapp

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_row.view.*

class ListAdapter(val context: Context, val list: List<String>, val pList: List<String>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val contactName: TextView = view.contact

        init{
            itemView.setOnClickListener{

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: String = list[position]
        holder.contactName.text = contact
        holder.itemView.setOnClickListener{
            val builder = AlertDialog.Builder(context)

            builder.setTitle("Edit Contact")
            builder.setMessage("Edit this contact?")

            builder.setPositiveButton(R.string.edit){dialog, which ->
                val editCon = Intent(context, EditContactActivity::class.java)
                editCon.putExtra("phone", pList[position])
                context.startActivity(editCon)
            }
            builder.setNegativeButton(R.string.delete){dialog, which ->
                val delCon = Intent(context, DeleteContactActivity::class.java)
                delCon.putExtra("phone", pList[position])
                context.startActivity(delCon)
            }
            builder.setNeutralButton(R.string.cancel){dialog, which ->

            }
            builder.create()
            builder.show()
        }
    }

    override fun getItemCount(): Int = list.size
}