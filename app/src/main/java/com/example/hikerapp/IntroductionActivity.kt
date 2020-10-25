package com.example.hikerapp

import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

@Suppress("DEPRECATION")
class IntroductionActivity : AppCompatActivity() {
    //Variables
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var logo: TextView
    private lateinit var background:ImageView

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ScreenSlidePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_introduction)

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        //Applying the animations
        background = findViewById(R.id.img)
        image1 = findViewById(R.id.imageView)
        image2 = findViewById(R.id.imageView1)
        logo = findViewById(R.id.textView)

        viewPager = findViewById(R.id.pager)
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        image1.animation = topAnim
        logo.animation = bottomAnim
        image2.animation = bottomAnim

        background.animate().translationY(-2500F).setDuration(1000).startDelay = 3000
        logo.animate().translationY(2000F).setDuration(1000).startDelay = 3000
        image1.animate().translationY(2000F).setDuration(1000).startDelay = 3000
        image2.animate().translationY(2000F).setDuration(1000).startDelay = 3000

    }

    private class ScreenSlidePagerAdapter(@NonNull fm:FragmentManager):FragmentStatePagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        override fun getItem(position:Int): Fragment {
            when (position) {
                0 -> {
                    return OnBoardingFrag1()
                }
                1 -> {
                    return OnBoardingFrag2()
                }
                else -> {
                }
            }
            return OnBoardingFrag1()
        }

        @NonNull
        override fun getCount():Int {
            return 2
        }
    }

}
