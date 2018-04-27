package edu.uw.ischool.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    companion object {
        val TOPIC = "Topic"
        val DESCRIPTION = "Description"
        val QUESTIONS = "Questions"
        val ANSWERS = "Answers"
        //val OPTIONS = "Options"
        val INDEX = "Index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val topics = arrayOf("Math", "Physics","Marvel Super Heroes", "Movies", "Soccer", "Random")
        val topicDesc = arrayOf("A lot of numbers", "Something that won't let you defy it's laws", "The better version of DC Super Heroes (Except for Batman)",
                "It's like a book, but it can talk and move", "The real football", "Shit. I dont know")


        val listView = findViewById(R.id.listView) as ListView

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text2 ,topics)

        listView.adapter = adapter as ListAdapter?

        listView.setOnItemClickListener({ parent, v, position, id ->
            val intent = Intent(v.context, SecondActivity::class.java)
            intent.putExtra(TOPIC,topics[position])
            intent.putExtra(DESCRIPTION, topicDesc[position])
            intent.putExtra(INDEX, position)

            v.context.startActivity(intent)
        })
    }
}
