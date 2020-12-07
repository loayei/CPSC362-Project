/*
package com.example.hikerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class StaticRvAdapter(items:ArrayList<StaticRvModel>):RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder>() {
    private val items:ArrayList<StaticRvModel> = items
    private var row_index = -1
    override fun getItemCount(): Int {
            return items.size;
        }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent:ViewGroup, viewType:Int):StaticRVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.static_rv_item, parent, false)
        return StaticRVViewHolder(view)
    }
    override fun onBindViewHolder(@NonNull holder:StaticRVViewHolder, position:Int) {
        val currentItem = items[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text = currentItem.text
        holder.linearLayout.setOnClickListener(View.OnClickListener(
            fun(v: View) {
                row_index = position
                notifyDataSetChanged()

        }))
        if (row_index === position)
        {
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg)
        }
        else
        {
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg)
        }
    }
    class StaticRVViewHolder(@NonNull itemView:View):RecyclerView.ViewHolder(itemView) {
        internal var textView:TextView = itemView.findViewById(R.id.text1)
        internal var imageView:ImageView = itemView.findViewById(R.id.image1)
        internal var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)

    }

}
 */