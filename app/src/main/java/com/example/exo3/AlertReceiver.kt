package com.example.exo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
//import android.support.v4.app.NotificationCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlertReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
       var sound : Uri = Uri.parse("android.resource://com.example.exo3/raw/" + R.raw.song1)
        /*val notificationHelper = NotificationHelper(context)
        val nb: NotificationCompat.Builder = notificationHelper.getChannelNotification()
        notificationHelper.getManager().notify(1, nb.build())*/
        var notif : NotificationCompat.Builder = NotificationCompat.Builder(context!!,"notifyLemubit")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("adhan remider")
            .setContentText("hi this is adhan of dohar")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSound(sound)
        var manager : NotificationManagerCompat = NotificationManagerCompat.from(context)
        manager.notify(200 , notif.build())
 
    }
}