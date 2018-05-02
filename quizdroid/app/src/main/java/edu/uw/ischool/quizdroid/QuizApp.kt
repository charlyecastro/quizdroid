package edu.uw.ischool.quizdroid

import android.app.Application
import android.util.Log

class QuizApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp", "Loaded!")
    }



}