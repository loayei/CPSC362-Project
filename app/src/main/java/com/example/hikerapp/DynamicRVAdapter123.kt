/*
package com.example.hikerapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hikerapp.DRVinterface.LoadMore
import org.json.JSONObject.NULL

internal class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var progressBar: ProgressBar = itemView.findViewById(R.id.progress_bar)

}

internal class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name)

}

class DynamicRVAdapter(
    recyclerView: RecyclerView,
    var activity: Activity,
    var items: List<DynamicRVModel?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    lateinit var loadMore: LoadMore
    var isLoading = false
    var visibleThreshold = 5
    var lastVisibleItem = 0
    var totalItemCount = 0
    override fun getItemViewType(position: Int): Int {
        return if (items[position] == null) VIEW_TYPE_LOADING else VIEW_TYPE_LOADING
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(activity)
                .inflate(R.layout.dynamic_rv_item_layout, parent, false)
            return LoadingViewHolder(view)
        } else if (viewType == VIEW_TYPE_LOADING) {
            val view = LayoutInflater.from(activity)
                .inflate(R.layout.dynamic_rv_progress_bar, parent, false)
            return LoadingViewHolder(view)
        }
         return null!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = items[position]
            holder.name.text = items[position]!!.name
        } else if (holder is LoadingViewHolder) {
            val loadingViewHolder = holder
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setLoaded() {
        isLoading = false
    }

    fun setLoadMore(loadMore: LoadMore) {

    }

    init {
        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManager!!.itemCount
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition()
                if (!isLoading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                    if (loadMore != null) loadMore!!.onLoadMore()
                    isLoading = true
                }
            }
        })
    }
}
 */