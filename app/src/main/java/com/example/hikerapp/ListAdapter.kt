package com.example.hikerapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_row.view.*

class ListAdapter(val context: Context, val list: List<String>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var onItemClick: ((String) -> Unit)? = null
        val contactName: TextView = view.contact

        init{
            itemView.setOnClickListener{

            }
        }

        //fun bind(entry: String, clickListener: AdapterView.OnItemClickListener){
          //  contactName.text = entry

            //itemView.setOnClickListener{
              //  clickListener.invoke(entry)
            //}
       // }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: String = list[position]
        //holder.bind(list[position], itemClickListener)
        holder.contactName.text = contact
        //holder.itemView.setOnClickListener{ listener(contact)}
        holder.itemView.setOnClickListener{
            val builder = AlertDialog.Builder(context)

            builder.setTitle("Edit Contact")
            builder.setMessage("Edit this contact?")

            builder.setPositiveButton(R.string.edit){dialog, which ->


            }
            builder.setNegativeButton(R.string.delete){dialog, which ->

            }
            builder.setNeutralButton(R.string.Back){dialog, which ->

            }
            builder.create()
            builder.show()
        }
    }

    override fun getItemCount(): Int = list.size
}