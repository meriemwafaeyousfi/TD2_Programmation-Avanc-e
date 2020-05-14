package com.example.exo3

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        var btn : Button = findViewById(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
             var intent : Intent = Intent(this@MainActivity,Notif::class.java)
               var pintent : PendingIntent = PendingIntent.getBroadcast(this@MainActivity,0,intent,0)
                var amanager : AlarmManager=  getSystemService(Context.ALARM_SERVICE) as AlarmManager
                var time : Long = System.currentTimeMillis()
                var ten : Long = 1000 * 10
                amanager.set(AlarmManager.RTC_WAKEUP,time*ten,pintent)
            }
        })

    }
    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var name : CharSequence ="LenubitRemiderChannel"
            var des = "Channel for lemubit Remider"
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel : NotificationChannel = NotificationChannel("notifyLemubit",name,importance)
            channel.description = des
            var nm : NotificationManager = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(channel)

        }
    }
}
