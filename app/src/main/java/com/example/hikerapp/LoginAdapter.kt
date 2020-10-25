package com.example.hikerapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
class LoginAdapter(fm:FragmentManager, context:Context, totalTabs:Int):FragmentPagerAdapter(fm) {
    private val context:Context = context
    private var totalTabs:Int = totalTabs

    override fun getCount(): Int {
        return this.totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return LoginTabFragment()
            }
            1 -> {
                return SignupTabFragment()
            }
            else -> null!!
        }
    }
}