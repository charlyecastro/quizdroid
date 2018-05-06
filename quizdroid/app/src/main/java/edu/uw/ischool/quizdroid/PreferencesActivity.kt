package edu.uw.ischool.quizdroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.google.gson.internal.bind.DateTypeAdapter

@Suppress("DEPRECATION")
class PreferencesActivity : AppCompatActivity() {

    companion object {
        val SOURCE = "source"
        val DOWNLOAD = "download"
        val JSON = "json"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        supportActionBar?.title = "Preferences"

        var check = false
        var download = "1"
        var json : String = "http://tednewardsandbox.site44.com/questions.json"

        var spin = findViewById(R.id.spin) as Spinner
        var percentages = arrayOf("1 Minute", "5 Minutes", "10 Minutes", "15 Minutes" )
        spin.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,percentages)
        spin.setSelection(1)

        val switch = findViewById<Switch>(R.id.switch1) as Switch
        //switch.setChecked(true)

        val btnSave = findViewById(R.id.save) as Button

        val prefs = getSharedPreferences("pref", Context.MODE_WORLD_READABLE)
        var bool = prefs.getBoolean("check", false)
        switch.setChecked(bool)

        switch.setOnCheckedChangeListener( { compoundButton: CompoundButton, b: Boolean ->
            if(b) {
                check = true
                json = "https://charlyecastro.github.io/myJSON/myQuestions.json"

            } else {
                check = false
                json = "http://tednewardsandbox.site44.com/questions.json"
            }
        })

        val preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE)
        val editor = preferences.edit()
        editor.putString("json", json)
        editor.putBoolean("check", check)

        btnSave.setOnClickListener({v ->
            val intent = Intent(v.context, MainActivity::class.java)

            val preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE)
            val editor = preferences.edit()
            editor.putString("json", json)
            editor.putBoolean("check", check)
            editor.apply()
            v.context.startActivity(intent)
        })


    }
}

