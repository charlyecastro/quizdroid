package edu.uw.ischool.quizdroid

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.*
import android.os.AsyncTask
import android.preference.PreferenceManager
import android.widget.Toast
import org.json.JSONArray
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL


class QuizApp : Application() {

    companion object {
        lateinit var topics: Array<Topic>
        lateinit var source :String
    }

    override fun onCreate() {
                super.onCreate()
        Log.i("QuizApp", "Loaded!")
    }

    fun setSource(input : String) {
        source = input
    }

    fun getRepository(): TopicRepository {
        return TopicRepository()
    }

    class Quiz(var text: String?, var answer: Int?, var answers: Array<String>?) {
    }

    class Topic(var title: String?, var desc: String?, var questions: ArrayList<Quiz>) {
    }

    class TopicRepository : AsyncTask<String, String, String>{

       // val top = ArrayList<Topic>()
        var url = ""
        var url2 = ""


        constructor() {

            url2 = "https://charlyecastro.github.io/myJSON/myQuestions.json"
            url = "http://tednewardsandbox.site44.com/questions.json"

            execute(url).get()
        }

        override fun doInBackground(vararg p0: String?): String {


            val connection = URL(source).openConnection() as HttpURLConnection
            var input = ""
            try {
                input = BufferedInputStream(connection.inputStream).use { it.reader().use { reader -> reader.readText() } }
            }
            finally {
                connection.disconnect()
            }

            val obj = JSONArray(input)
            val gson = GsonBuilder().create()
            topics = gson.fromJson(input, Array<Topic>::class.java)
            return input
        }


        fun getTops(): Array<Topic> {
            return topics
        }

        fun getList(): List<String> {
            var list = ArrayList<String>()
            for(i in topics.indices) {
                list.add(topics[i].title!!)
            }
            return list
        }
    }

}