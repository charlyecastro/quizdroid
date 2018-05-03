package edu.uw.ischool.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    companion object {
        val TOPIC = "Topic"
        val DESCRIPTION = "Description"
        val INDEX = "Index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getRepo
        val app = QuizApp()
        val repo = app.getRepository()
        val topics = repo.getTopics()

        val listView = findViewById<ListView>(R.id.listView) as ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text2 ,repo.getList())
        listView.adapter = adapter

        listView.setOnItemClickListener({ parent, v, position, id ->
            val intent = Intent(v.context, SecondActivity::class.java)
            //Log.i("test", "position " + position + " topic " + topics[position].title)
            intent.putExtra(TOPIC,topics[position].title)
            intent.putExtra(DESCRIPTION, topics[position].longDesc)
            intent.putExtra(INDEX, position)

            v.context.startActivity(intent)
        })
    }
}
