package edu.uw.ischool.quizdroid

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import edu.uw.ischool.quizdroid.QuestionFragment.Companion.SELECTED

class AnswerFragment : Fragment() {

    val mathA = arrayOf("2", "a^2 + b^2 = c^2", "Physical Education")
    val physicsA = arrayOf("mc^2", "3", "9.807 m/s^2")
    val marvelA = arrayOf("Peter Parker", "Wolverine", "Walt Disney")
    val moviesA = arrayOf("The Dark Knight", "Titanic", "The Room")
    val soccerA = arrayOf("5", "Mo Salah", "Russia")
    val randomA = arrayOf("Walt Disney", "The Office", "Yes")

    val answers = arrayOf(mathA, physicsA, marvelA, moviesA, soccerA, randomA)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val result = inflater?.inflate(R.layout.answer_fragment,container,false)

            val index = arguments!!.getInt(MainActivity.INDEX, 0)
            var qIndex = arguments!!.getInt(SecondActivity.Q_INDEX, 0)
            val submitted = arguments!!.getString(SELECTED)
            var count = arguments!!.getInt(SecondActivity.COUNT, 0)
            val correct = answers[index][qIndex]

             if (correct == submitted) {
                 count++
             }
                qIndex++

            val correctText = result?.findViewById(R.id.correct) as TextView
            val submittedText = result?.findViewById(R.id.submitted) as TextView
            val scoreText = result?.findViewById(R.id.score) as TextView
            val btn = result?.findViewById(R.id.button) as Button

            if (qIndex == 3) {
                btn.text = "Finish"
            }

            correctText.text = "Correct Answer: " + correct
            submittedText.text = "Your Answer: " + submitted
            scoreText.text = "You have " + count + " out of " + qIndex + " correct"

            btn.setOnClickListener({v ->

            if(btn.text == "Next") {
                val fragment = QuestionFragment()
                val transaction = fragmentManager.beginTransaction()
                val bundle = Bundle()
                bundle.putInt(MainActivity.INDEX,index)
                bundle.putInt(OverviewFragment.COUNT, count)
                bundle.putInt(OverviewFragment.Q_INDEX, qIndex)
                fragment.arguments = bundle
                transaction.replace(R.id.fragment, fragment)
                transaction.commit()
            } else {
                val intent = Intent(v.context, MainActivity::class.java)
                v.context.startActivity(intent)

            }
        })


        return result
    }
}