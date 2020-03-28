package com.example.pushnotificationkt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.urbanairship.UAirship

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //user notification enable
        UAirship.shared().pushManager.userNotificationsEnabled = true

        //channel id
        var channelId = UAirship.shared().pushManager.channelId
        if(channelId!=null) {
            Log.d("@@@TAG chid : ", channelId.toString())
        }else{
            channelId = UAirship.shared().pushManager.channelId
            Log.d("@@@TAG chid else : ", channelId.toString())
        }

    }

}
