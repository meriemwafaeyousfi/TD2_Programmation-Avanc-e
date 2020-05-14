package com.example.exo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notif() : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var notif : NotificationCompat.Builder = NotificationCompat.Builder(context!!,"notifyLemubit")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("adhan remider")
            .setContentText("hi this is adhan of dohar")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var manager :NotificationManagerCompat = NotificationManagerCompat.from(context)
        manager.notify(200 , notif.build())
    }
}