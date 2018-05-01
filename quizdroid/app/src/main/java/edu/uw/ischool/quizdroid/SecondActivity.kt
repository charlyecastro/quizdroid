package edu.uw.ischool.quizdroid

import android.annotation.SuppressLint
import android.app.Fragment
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

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.title = "Topic Overview"


        var fragmentManager = fragmentManager
        var fragment = OverviewFragment()


            val topic = intent.getStringExtra(TOPIC)
            val desc = intent.getStringExtra(DESCRIPTION)
            val index = intent.getIntExtra(INDEX, 0)


            val transaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putString(TOPIC,topic)
            bundle.putString(DESCRIPTION,desc)
            bundle.putInt(INDEX,index)
            fragment.arguments = bundle
            transaction.replace(R.id.fragment, fragment)
            supportActionBar?.title = topic
            transaction.commit()
    }

}