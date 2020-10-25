package com.example.hikerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlin.math.log

class LoginTabFragment() : Fragment() {

    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var forgetpass: TextView
    private lateinit var login: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var root = inflater.inflate(R.layout.login_tab_fragment, container, false) as ViewGroup
        email = root.findViewById(R.id.email)
        pass = root.findViewById(R.id.pass)
        forgetpass = root.findViewById(R.id.forgetpass)
        login = root.findViewById(R.id.loginbutton)

        email.translationY = 500F
        pass.translationY = 500F
        forgetpass.translationY = 500F
        login.translationY = 500F

        email.alpha = 0F
        pass.alpha = 0F
        forgetpass.alpha = 0F
        login.alpha = 0F


        email.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(300).start()
        pass.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start()
        forgetpass.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(500).start()
        login.animate().translationY(0F).alpha(1F).setDuration(800).setStartDelay(700).start()


        return root
    }
}