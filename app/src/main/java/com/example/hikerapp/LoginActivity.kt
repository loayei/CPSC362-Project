package com.example.hikerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.GRAVITY_FILL

class LoginActivity : AppCompatActivity() {

    lateinit var tablayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var google: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tablayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        google = findViewById(R.id.fab_google)

        tablayout.addTab(tablayout.newTab().setText("LOGIN"));
        tablayout.addTab(tablayout.newTab().setText("SIGNUP"));
        tablayout.tabGravity = GRAVITY_FILL

        val adapter = LoginAdapter(supportFragmentManager, this, tablayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        google.translationY = 300F
        tablayout.translationY = 300F

        google.alpha = 0F
        tablayout.alpha = 1F
        google.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(400).start()
    }
}