package com.example.exo3

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
//import android.support.v4.app.DialogFragment
//import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(), OnTimeSetListener {
    private var mTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.textView)
        val buttonTimePicker =
            findViewById<Button>(R.id.button_timepicker)
        buttonTimePicker.setOnClickListener {
            val timePicker: DialogFragment = TimePickerFragment()
            timePicker.show(supportFragmentManager, "time picker")
        }
        val buttonCancelAlarm =
            findViewById<Button>(R.id.button_cancel)
        buttonCancelAlarm.setOnClickListener { cancelAlarm() }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val c = Calendar.getInstance()
        c[Calendar.HOUR_OF_DAY] = hourOfDay
        c[Calendar.MINUTE] = minute
        c[Calendar.SECOND] = 0
        updateTimeText(c)
        startAlarm(c)
    }

    private fun updateTimeText(c: Calendar) {
        var timeText: String? = "Alarm set for: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT)
            .format(c.time)
        mTextView!!.text = timeText
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun startAlarm(c: Calendar) {
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1)
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.timeInMillis, pendingIntent)
    }

    private fun cancelAlarm() {
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
        alarmManager.cancel(pendingIntent)
        mTextView!!.text = "Alarm canceled"
    }
}

