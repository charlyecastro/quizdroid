package edu.uw.ischool.quizdroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import edu.uw.ischool.quizdroid.PreferencesActivity.Companion.DOWNLOAD
import edu.uw.ischool.quizdroid.PreferencesActivity.Companion.JSON
import edu.uw.ischool.quizdroid.PreferencesActivity.Companion.SOURCE

//https://charlyecastro.github.io/myJSON/myQuestions.json

class MainActivity : AppCompatActivity() {

    companion object {
        val TOPIC = "Topic"
        val DESCRIPTION = "Description"
        val INDEX = "Index"
        val NUMQ = "numQ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setLogo(R.mipmap.ic_launcher)
        getSupportActionBar()!!.setDisplayUseLogoEnabled(true)

        //getRepo

        val preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE)
        var json = preferences.getString("json", "")

        val app = QuizApp()
        app.setSource(json)
        val repo = app.getRepository()
        val topics = repo.getTops()

        val listView = findViewById<ListView>(R.id.listView) as ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text2 ,repo.getList())
        listView.adapter = adapter as ListAdapter?

        listView.setOnItemClickListener({ parent, v, position, id ->
            val intent = Intent(v.context, SecondActivity::class.java)
            val num = topics[position].questions.size
            intent.putExtra(TOPIC,topics[position].title)
            intent.putExtra(DESCRIPTION, topics[position].desc)
            intent.putExtra(INDEX, position)
            intent.putExtra(NUMQ, num)

            v.context.startActivity(intent)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            R.id.preferences -> {
                val intent = Intent(this , PreferencesActivity::class.java)
                startActivity(intent)
                return super.onOptionsItemSelected(item)
            }
            else ->  return super.onOptionsItemSelected(item)
        }
    }
}
