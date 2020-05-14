package com.example.exo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exo4.MotAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mots:MutableList<Mot> = mutableListOf<Mot>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            mots.add(Mot("un robinet ","definition d'un robinet", R.drawable.farm,R.raw.song1,R.raw.video))
            mots.add(Mot("la peur ", "definition de la peur", R.drawable.farm,R.raw.song2,R.raw.video2))
            mots.add(Mot("mot 3 ", "def3", R.drawable.farm,R.raw.song1,0))
            mots.add(Mot("mot 4 ", "def4",R.drawable.sheep,R.raw.song1,0))
            mots.add(Mot("mot 5 ", "def5",R.drawable.sheep,R.raw.song1,0))
            mots.add(Mot("mot 6 ","def6", R.drawable.sheep,R.raw.song1,0))
            mots.add(Mot("mot 7 ","def7", R.drawable.sheep,R.raw.song1,0))
            mots.add(Mot("mot 8 ","def8", R.drawable.farm,R.raw.song1,0))
            mots.add(Mot("mot 9 ","def9",  R.drawable.farm,R.raw.song1,0))
            mots.add(Mot("mot 10 ", "def10", R.drawable.farm,R.raw.song1,0))

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager= layoutManager
        val adapter = MotAdapter(this,mots)
        list.adapter= adapter

    }
}
