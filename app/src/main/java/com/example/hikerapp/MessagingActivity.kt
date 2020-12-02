package com.example.hikerapp

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.messaging.*
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

class MessagingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messaging)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.SEND_SMS),
                111
            )
        } else {

            set_interval_button.setOnClickListener(){
                var textFrequency = setTimeInterval.text.toString()
                if (textFrequency.isEmpty()) {
                    Toast.makeText(this, "Please enter a time value interval in minutes", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                checkSwitch()
            }

        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            sendMsg()
    }

    private fun getFrequency() : Long {
        var textFrequency = setTimeInterval.text.toString()
        var frequency = textFrequency.toLong()
        frequency *= 60000
        Toast.makeText(this, "Frequency is $frequency", Toast.LENGTH_LONG).show()
        return frequency
    }

    private fun checkSwitch() {
        var timer: Timer? = null
        var frequency = getFrequency()
        message_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                timer = Timer()
                timer!!.schedule(object: TimerTask() {
                    override fun run() {
                        sendMsg()
                    } }, 0, frequency)
                //Toast.makeText(this, "Timer started with freq: $frequency", Toast.LENGTH_LONG).show()
            } else {
                timer?.cancel()
                timer?.purge()
                Toast.makeText(this, "switch turned off, cancel timer", Toast.LENGTH_LONG).show()
            }

        }
    }

//    private fun startTimer(frequency: Long, status: Boolean){
//
//        if(!status){
//            Toast.makeText(this, "Attempting to cancel and purge tasks", Toast.LENGTH_LONG).show()
//            Timer().cancel()
//            Timer().purge()
//        } else {
//            Timer().scheduleAtFixedRate(object: TimerTask(){
//            override fun run() {
//                if (status){
//                    sendMsg()
//                } else {
//                    return
//                }
//            }
//            },0 , frequency)
//
//        }
//        Timer().cancel()
//        Timer().purge()
//    }

    private fun sendMsg() {
        var phoneNumber = "9095551212"
        var sms = SmsManager.getDefault()
        var message = "Hey it's John! I'm currently on a hike. The signal is bad but I'm safe. Here's my location: 37.8824, -121.9153 "
        sms.sendTextMessage(
            phoneNumber,
            "ME",
            message,
            null,
            null
        )



    }

}