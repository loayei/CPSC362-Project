/*
package com.example.hikerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hikerapp.DRVinterface.LoadMore
import java.util.*
import kotlin.collections.ArrayList

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var staticRvAdapter: StaticRvModel

    private val items:MutableList<DynamicRVModel?> = ArrayList()
    lateinit var dynamicRVAdapter:DynamicRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val item:ArrayList<StaticRvModel> = ArrayList()
        item.add(StaticRvModel(R.drawable.main_screen_logo, "1"))
        item.add(StaticRvModel(R.drawable.main_screen_logo, "2"))
        item.add(StaticRvModel(R.drawable.main_screen_logo, "3"))
        item.add(StaticRvModel(R.drawable.main_screen_logo, "4"))
        item.add(StaticRvModel(R.drawable.main_screen_logo, "5"))

        recyclerView = findViewById(R.id.rv_1)
        staticRvAdapter = StaticRvModel(item)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = staticRvAdapter

        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))
        items.add(DynamicRVModel("log"))


        dynamicRVAdapter.setLoadMore(object: LoadMore {
            override fun onLoadMore() {
                if (items.size <= 10)
                {
                    items.add(null)
                    dynamicRVAdapter.notifyItemInserted(items.size - 1)
                    Handler().postDelayed(object:Runnable {
                        public override fun run() {
                            items.removeAt(items.size - 1)
                            dynamicRVAdapter.notifyItemRemoved(items.size)
                            val index = items.size
                            val end = index + 10
                            for (i in index until end)
                            {
                                val name = UUID.randomUUID().toString()
                                val item = DynamicRVModel(name)
                                items.add(item)
                            }
                            dynamicRVAdapter.notifyDataSetChanged()
                            dynamicRVAdapter.setLoaded()
                        }
                    }, 4000)
                }
                else
                    Toast.makeText(this@DashboardActivity, "Data completed", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
 */