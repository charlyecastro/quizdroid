package edu.uw.ischool.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import edu.uw.ischool.quizdroid.SecondActivity.Companion.COUNT
import edu.uw.ischool.quizdroid.ThirdActivity.Companion.CORRECT
import edu.uw.ischool.quizdroid.ThirdActivity.Companion.SELECTED
import org.w3c.dom.Text

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val topics = arrayOf("Math", "Physics","Marvel Super Heroes", "Movies", "Soccer", "Random")

        val index = intent.getIntExtra(MainActivity.INDEX, 0)
        var qIndex = intent.getIntExtra(SecondActivity.Q_INDEX, 0) + 1
        val correct = intent.getStringExtra(CORRECT)
        val submitted = intent.getStringExtra(SELECTED)
        var correctCount = intent.getIntExtra(COUNT, 0)

        if (correct == submitted) {
            correctCount++
        }


        val correctText = findViewById(R.id.correct) as TextView
        val submittedText = findViewById(R.id.submitted) as TextView
        val scoreText = findViewById(R.id.score) as TextView
        val btn = findViewById(R.id.button) as Button
        if (qIndex == 3) {
            btn.text = "Finish"
        }

        val num = 0

        supportActionBar?.title = topics[index]
        correctText.text = "Correct Answer: " + correct
        submittedText.text = "Your Answer: " + submitted
        scoreText.text = "You have " + correctCount + " out of " + qIndex + " correct"

        btn.setOnClickListener({v ->

            if(btn.text == "Next") {
                val intent = Intent(v.context, ThirdActivity::class.java)
                intent.putExtra(MainActivity.INDEX, index)
                intent.putExtra(SecondActivity.Q_INDEX, qIndex)
                intent.putExtra(COUNT, correctCount)

                v.context.startActivity(intent)
            } else {
                val intent = Intent(v.context, MainActivity::class.java)
                v.context.startActivity(intent)

            }
        })
    }
}