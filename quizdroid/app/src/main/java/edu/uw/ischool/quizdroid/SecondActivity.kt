package edu.uw.ischool.quizdroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import edu.uw.ischool.quizdroid.MainActivity.Companion.ANSWERS
import edu.uw.ischool.quizdroid.MainActivity.Companion.DESCRIPTION
import edu.uw.ischool.quizdroid.MainActivity.Companion.INDEX
import edu.uw.ischool.quizdroid.MainActivity.Companion.QUESTIONS
import edu.uw.ischool.quizdroid.MainActivity.Companion.TOPIC
import org.w3c.dom.Text


class SecondActivity : AppCompatActivity() {

    companion object {
        val Q_INDEX = "qIndex"
        val COUNT = "count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.title = "Topic Overview"

        val topicName = findViewById(R.id.topicName) as TextView
        val topicDesc = findViewById(R.id.topicDesc) as TextView

        val beginButton = findViewById(R.id.begin) as Button

        topicName.setText(intent.getStringExtra(TOPIC))
        topicDesc.setText(intent.getStringExtra(DESCRIPTION))

        val index = intent.getIntExtra(INDEX, 0)

        beginButton.setOnClickListener({ v ->
            val intent = Intent(v.context, ThirdActivity::class.java)

            intent.putExtra(INDEX, index)
            intent.putExtra(Q_INDEX, 0)
            intent.putExtra(COUNT, 0)

            v.context.startActivity(intent)
        })

    }

}