package com.example.td4_exo3_2

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.example_item.*
import java.time.LocalDate
import kotlin.random.Random


class MainActivity : AppCompatActivity() /*, ExempleAdapter.OnTaskListner*/ {

    lateinit var exampleList : List<ExampleItem>
    //lateinit var onTaskListner : ExempleAdapter.OnTaskListner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList1 = generateDummyList1(30)
        val exampleList2 = generateDummyList2(20)
        var exampleList = exampleList1 +exampleList2
        recycler_view.adapter = ExempleAdapter(exampleList/*, onTaskListner*/)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        btn_add.setOnClickListener(View.OnClickListener {
            var item = ExampleItem(R.drawable.ic_create, edit_text.text.toString(), "random")
            exampleList+=item
            (recycler_view.adapter as ExempleAdapter).notifyDataSetChanged()
            Toast.makeText(this@MainActivity, "${exampleList.size} tâches en cours", Toast.LENGTH_SHORT).show()
        })
    }

    private fun generateDummyList1(size: Int): List<ExampleItem> {

        val list = ArrayList<ExampleItem>()


        for (i in 0 until size) {

            /*var random = Random(30)
            var minDay = LocalDate.of(1900, 1, 1).toEpochDay() as Int
            var maxDay = LocalDate.of(2015, 1, 1).toEpochDay() as Int
            var randomDay: Long = (minDay + random.nextInt(maxDay - minDay)).toLong()
            val randomBirthDate: LocalDate = LocalDate.ofEpochDay(randomDay)*/

            val drawable = R.drawable.ic_create
            val item = ExampleItem(drawable, "Tache $i", "Du le 10/04/2020")
            list += item
        }

        return list
    }

    private fun generateDummyList2(size: Int): List<ExampleItem> {

        val list  = ArrayList<ExampleItem>()


        for (i in 0 until size) {

            val drawable = R.drawable.ic_create
            val item = ExampleItem(drawable, "Tache $i", "Du le 15/03/2020")
            list += item
        }

        return list
    }
/*
     override fun onTaskClick(position: Int) {
        exampleList.toMutableList().removeAt(position)
        recycler_view.adapter!!.notifyDataSetChanged()
    }*/
}
