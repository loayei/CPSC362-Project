/*
package com.example.hikerapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hikerapp.DRVinterface.LoadMore


internal class LoadingViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var progressBar: ProgressBar = itemView.findViewById(R.id.progress_bar)
}

internal class ItemViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name)
}

class DynamicRVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    internal lateinit var loadMore: LoadMore
    internal var isLoading: Boolean = false
    private lateinit var activity: Activity
    private lateinit var items: List<DynamicRVModel>
    internal var visibleThreshold = 5
    internal var lastVisibleItem: Int = 0
    internal var totalItemCount: Int = 0

    init {
        this.activity = activity
        this.items = items
        val linearLayoutManager: LinearLayoutManager = recyclerView.getLayoutManager()
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManager.itemCount
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

 */