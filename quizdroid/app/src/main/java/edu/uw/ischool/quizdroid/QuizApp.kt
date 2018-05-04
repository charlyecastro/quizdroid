package edu.uw.ischool.quizdroid

import android.app.Application
import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.*


class QuizApp : Application() {


    companion object {
          var topics: Array<Topic> =  arrayOf(Topic("Loading!",
         "Loading!", arrayListOf(Quiz("What is fire?", 1, arrayOf("hello"))) ) )


    }
    override fun onCreate() {
                super.onCreate()
        Log.i("QuizApp", "Loaded!")
    }

    fun getRepository(): TopicRepository {
        return TopicRepository()
    }


    class Quiz(var text: String?, var answer: Int?, var answers: Array<String>?) {
    }

    class Topic(var title: String?, var desc: String?, var questions: ArrayList<Quiz>) {
    }

    class TopicRepository {

        fun getTops(): Array<Topic> {
            fetchJson()
            return topics
            
        }

        fun getList(): List<String> {
            var list = ArrayList<String>()
            for(i in topics.indices) {
                list.add(topics[i].title!!)
            }
            return list
        }

        fun fetchJson() {

            var top : Array<Topic>

            val url = "http://tednewardsandbox.site44.com/questions.json"
            val request = Request.Builder().url(url).build()

            val client = OkHttpClient()
            client.newCall(request).enqueue(object: Callback {

                override fun onResponse(call: Call?, response: Response?) {
                    val body = response?.body()?.string()
                    println(body)

                    val gson = GsonBuilder().create()
                    topics = gson.fromJson(body, Array<Topic>::class.java)
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    Log.e("ERROR", "failed to execute request")
                }

            } )
        }
    }

}



//        val topicList = arrayOf("Math", "Physics","Marvel Super Heroes", "Movies", "Soccer", "Random")
//        val topicDesc = arrayOf("A lot of numbers", "Something that won't let you defy it's laws", "The better version of DC Super Heroes (Except for Batman)",
//                "It's like a book, but it can talk and move", "The real football", "Shit. I dont know")
//
//
//        // Subject Questions
//        val mathQ = arrayOf("1 + 1 equals?", "Which is the formula for the Pythagorean theorem", "Which of the following is not a math subject")
//        val physicsQ = arrayOf("E equals?", "How many laws does Newton have?", "What is Earths gravitational acceleration?")
//        val marvelQ = arrayOf("Who is Spider Man?", "Who is NOT a member of the Avengers?", "Who owns Marvel?")
//        val moviesQ = arrayOf("Which of these movies was released in 2008?", "Which movie won the most Oscars in 1997", "The Disaster Artist is based on which film?")
//        val soccerQ = arrayOf("How many Balon d'Or has Cristiano Ronaldo won?", "Who is currently the top lead scorer in the English Premiere League?", "Where is the 2018 World Cup taking place?")
//        val randomQ = arrayOf("Which of these companies own ESPN?", "What is the most popular show on Netflix?", "Do you matter?")
//
//        val questions = arrayOf(mathQ, physicsQ, marvelQ, moviesQ, soccerQ, randomQ)
//
//
//        //Subject Options
//        val mathO = arrayOf(arrayOf("11", "2", "-100", "81"),
//                arrayOf("b - (b * a) = c", "PI * R^2 = A", "a^2 + b^2 = c^2", "MC^2 = E"),
//                arrayOf("Physical Education", "Algebra", "Geometry", "Calculus"))
//
//        val physicsO = arrayOf(arrayOf("mc^2", "d/t", "l * w", "mv"),
//                arrayOf("4", "8", "3", "15"),
//                arrayOf("3.14 m/s^2", "9.807 m/s^2", "5.34 m/s^2", "9.801 m/s^2"))
//
//        val marvelO = arrayOf(arrayOf("Tony Stark", "Peter Parker", "Bruce Wayne", "Bruce Banner"),
//                arrayOf("Hulk", "Black Widow", "Bruce Banner", "Wolverine"),
//                arrayOf("Walt Disney", "COMCAST", "FOX", "Time Warner"))
//
//        val moviesO = arrayOf(arrayOf("Dead Pool", "Forrest Gump", "The Dark Knight", "Zodiac"),
//                arrayOf("Gattaca", "Forrest Gump", "Good Will Hunting", "Titanic"),
//                arrayOf("The Usual Suspects", "The Room", "Forrest Gump", "Her"))
//
//        val soccerO = arrayOf(arrayOf("5", "3", "2", "7"),
//                arrayOf("Harry Kane", "Sergio Aguero", "Andres Iniesta", "Mo Salah"),
//                arrayOf("Russia", "Germany", "Argentina", "Paraguay"))
//
//        val randomO = arrayOf(arrayOf("Nike", "Walt Disney", "Time Warner", "Adidas"),
//                arrayOf("Stranger Things", "On My Block", "The Office", "Rick and Morty"),
//                arrayOf("I Don't Know", "Nope", "Yes", "Who Cares"))
//
//        val options = arrayListOf(mathO, physicsO, marvelO, moviesO, soccerO, randomO)
//
//
//        val mathA = arrayOf(1, 2, 0)
//        val physicsA = arrayOf(0, 2, 1)
//        val marvelA = arrayOf(1, 3, 0)
//        val moviesA = arrayOf(2, 3, 1)
//        val soccerA = arrayOf(0, 3, 1)
//        val randomA = arrayOf(1, 2, 2)
//
//        val answers = arrayOf(mathA, physicsA, marvelA, moviesA, soccerA, randomA)

//lateinit var topics : List<Topic>

//        init {
//            for (i in topicList.indices) {
//                var quizzes = ArrayList<Quiz>()
//                for(j in questions[i].indices) {
//                    quizzes.add(Quiz(questions[i][j], answers[i][j], options[i][j]))
//                }
//                topics.add(Topic(topicList[i], topicDesc[i], quizzes))
//            }
//        }