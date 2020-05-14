package com.example.exo5

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.R.raw
import android.net.Uri
import android.widget.*

class MotActivity : AppCompatActivity() {
    var player: MediaPlayer? = null
    lateinit var imageMot: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mot)

        var mLayout : LinearLayout = findViewById(R.id.mLayout)
        var def = intent.getStringExtra("motDef") as String
        var vocal = intent.getIntExtra("vocal",0) as Int
        var vid = intent.getIntExtra("videoMot",0) as Int
        var mo = intent.getStringExtra("mot") as String
        val drawimg = intent.getIntExtra("motImg",0) as  Int
        var t: TextView = findViewById(R.id.definition)
        var m: TextView = findViewById(R.id.mot)
         imageMot = findViewById(R.id.imageMot)
        //imageMot.setImageResource(drawimg)
        t.text = def
        m.text = mo
        //val fileName = "video"
        if (vid != 0) {
            val filePlace = "android.resource://" + packageName + "/raw/" + vid
            val videoView = findViewById<View>(R.id.videoView) as VideoView
            videoView.setVideoURI(Uri.parse(filePlace))
            videoView.setMediaController(MediaController(this))
            videoView.start()
        }
        var btn : Button = findViewById(R.id.btnPlay)
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if(player == null){
                     player = MediaPlayer.create(this@MotActivity , vocal)
                    player?.start()
                }
                else{
                    player!!.release()
                    player = null
                }

            }

        }

        )
    }
    /*
    fun play (v : View) {
        if(player == null){
            player = MediaPlayer.create(this,R.raw.song)
            player?.start()
        }
        else{
            player!!.release()
            player = null
            player = MediaPlayer.create(this,R.raw.song)
            player?.start()
        }

    }*/
}
