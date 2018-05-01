package edu.uw.ischool.quizdroid

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import edu.uw.ischool.quizdroid.MainActivity.Companion.INDEX
import edu.uw.ischool.quizdroid.MainActivity.Companion.TOPIC
import edu.uw.ischool.quizdroid.SecondActivity.Companion.COUNT
import edu.uw.ischool.quizdroid.SecondActivity.Companion.Q_INDEX

class QuestionFragment : Fragment() {

    // Subject Questions
    val mathQ = arrayOf("1 + 1 equals?", "Which is the formula for the Pythagorean theorem", "Which of the following is not a math subject")
    val physicsQ = arrayOf("E equals?", "How many laws does Newton have?", "What is Earths gravitational acceleration?")
    val marvelQ = arrayOf("Who is Spider Man?", "Who is NOT a member of the Avengers?", "Who owns Marvel?")
    val moviesQ = arrayOf("Which of these movies was released in 2008?", "Which movie won the most Oscars in 1997", "The Disaster Artist is based on which film?")
    val soccerQ = arrayOf("How many Balon d'Or has Cristiano Ronaldo won?", "Who is currently the top lead scorer in the English Premiere League?", "Where is the 2018 World Cup taking place?")
    val randomQ = arrayOf("Which of these companies own ESPN?", "What is the most popular show on Netflix?", "Do you matter?")

    val questions = arrayOf(mathQ, physicsQ, marvelQ, moviesQ, soccerQ, randomQ)


    //Subject Options
    val mathO = arrayOf(arrayOf("11", "2", "-100", "81"),
            arrayOf("b - (b * a) = c", "PI * R^2 = A", "a^2 + b^2 = c^2", "MC^2 = E"),
            arrayOf("Physical Education", "Algebra", "Geometry", "Calculus"))

    val physicsO = arrayOf(arrayOf("mc^2", "d/t", "l * w", "mv"),
            arrayOf("4", "8", "3", "15"),
            arrayOf("3.14 m/s^2", "9.807 m/s^2", "5.34 m/s^2", "9.801 m/s^2"))

    val marvelO = arrayOf(arrayOf("Tony Stark", "Peter Parker", "Bruce Wayne", "Bruce Banner"),
            arrayOf("Hulk", "Black Widow", "Bruce Banner", "Wolverine"),
            arrayOf("Walt Disney", "COMCAST", "FOX", "Time Warner"))

    val moviesO = arrayOf(arrayOf("Dead Pool", "Forrest Gump", "The Dark Knight", "Zodiac"),
            arrayOf("Gattaca", "Forrest Gump", "Good Will Hunting", "Titanic"),
            arrayOf("The Usual Suspects", "The Room", "Forrest Gump", "Her"))

    val soccerO = arrayOf(arrayOf("5", "3", "2", "7"),
            arrayOf("Harry Kane", "Sergio Aguero", "Andres Iniesta", "Mo Salah"),
            arrayOf("Russia", "Germany", "Argentina", "Paraguay"))

    val randomO = arrayOf(arrayOf("Nike", "Walt Disney", "Time Warner", "Adidas"),
            arrayOf("Stranger Things", "On My Block", "The Office", "Rick and Morty"),
            arrayOf("I Don't Know", "Nope", "Yes", "Who Cares"))

    val options = arrayListOf(mathO, physicsO, marvelO, moviesO, soccerO, randomO)

    companion object {
        val SELECTED = "selected"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val result = inflater?.inflate(R.layout.question_fragment,container,false)


        var selected = "none"
        //var correct = aSet[qIndex]

        var quesNum = result?.findViewById(R.id.QuesNum) as TextView
        val question = result?.findViewById(R.id.Question) as TextView
        val submit = result?.findViewById(R.id.submit) as Button
        submit.setVisibility(View.GONE)

        val index = arguments!!.getInt(INDEX)
        val qIndex = arguments!!.getInt(Q_INDEX)
        val count = arguments!!.getInt(COUNT)


        quesNum.text = "Question " + (qIndex + 1)
        question.text = questions[index][qIndex]

        val btnArray = arrayOf(R.id.radioButton,
        R.id.radioButton2,
        R.id.radioButton3,
        R.id.radioButton4)

        var optionIndex = 0

        for (btn in btnArray) {
            val button = result?.findViewById(btn) as RadioButton
            button.text = options[index][qIndex][optionIndex]
            optionIndex++
            button.setOnClickListener {
                submit.setVisibility(View.VISIBLE)
                selected = button.text.toString()
            }
        }

        submit.setOnClickListener({
            val fragment = AnswerFragment()
            val transaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putInt(INDEX,index)
            bundle.putInt(OverviewFragment.COUNT, count)
            bundle.putInt(OverviewFragment.Q_INDEX, qIndex)
            bundle.putString(SELECTED, selected)
            fragment.arguments = bundle
            transaction.replace(R.id.fragment, fragment)
            transaction.commit()
        })

        return result

    }
}