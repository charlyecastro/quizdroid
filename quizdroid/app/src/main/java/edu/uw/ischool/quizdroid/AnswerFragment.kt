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

class AnswerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //Subject Answers
        val mathA = arrayOf("2", "a^2 + b^2 = c^2", "Physical Education")
        val physicsA = arrayOf("mc^2", "3", "9.807 m/s^2")
        val marvelA = arrayOf("Peter Parker", "Wolverine", "Walt Disney")
        val moviesA = arrayOf("The Dark Knight", "Titanic", "The Room")
        val soccerA = arrayOf("5", "Mo Salah", "Russia")
        val randomA = arrayOf("Walt Disney", "The Office", "Yes")

        val answers = arrayOf(mathA, physicsA, marvelA, moviesA, soccerA, randomA)

        return super.onCreateView(inflater, container, savedInstanceState)



//        package edu.uw.ischool.quizdroid
//
//        import android.content.Intent
//                import android.os.Bundle
//                import android.support.v7.app.AppCompatActivity
//                import android.widget.Button
//                import android.widget.TextView
//                import edu.uw.ischool.quizdroid.SecondActivity.Companion.COUNT
//                import edu.uw.ischool.quizdroid.ThirdActivity.Companion.CORRECT
//                import edu.uw.ischool.quizdroid.ThirdActivity.Companion.SELECTED
//                import org.w3c.dom.Text

//        class FourthActivity : AppCompatActivity() {
//            override fun onCreate(savedInstanceState: Bundle?) {
//                super.onCreate(savedInstanceState)
//                setContentView(R.layout.activity_fourth)
//
//                val topics = arrayOf("Math", "Physics","Marvel Super Heroes", "Movies", "Soccer", "Random")
//
//                val index = intent.getIntExtra(MainActivity.INDEX, 0)
//                var qIndex = intent.getIntExtra(SecondActivity.Q_INDEX, 0) + 1
//                val correct = intent.getStringExtra(ThirdActivity.CORRECT)
//                val submitted = intent.getStringExtra(ThirdActivity.SELECTED)
//                var correctCount = intent.getIntExtra(SecondActivity.COUNT, 0)
//
//                if (correct == submitted) {
//                    correctCount++
//                }
//
//
//                val correctText = findViewById(R.id.correct) as TextView
//                val submittedText = findViewById(R.id.submitted) as TextView
//                val scoreText = findViewById(R.id.score) as TextView
//                val btn = findViewById(R.id.button) as Button
//                if (qIndex == 3) {
//                    btn.text = "Finish"
//                }
//
//                val num = 0
//
//                supportActionBar?.title = topics[index]
//                correctText.text = "Correct Answer: " + correct
//                submittedText.text = "Your Answer: " + submitted
//                scoreText.text = "You have " + correctCount + " out of " + qIndex + " correct"
//
//                btn.setOnClickListener({v ->
//
//                    if(btn.text == "Next") {
//                        val intent = Intent(v.context, ThirdActivity::class.java)
//                        intent.putExtra(MainActivity.INDEX, index)
//                        intent.putExtra(SecondActivity.Q_INDEX, qIndex)
//                        intent.putExtra(SecondActivity.COUNT, correctCount)
//
//                        v.context.startActivity(intent)
//                    } else {
//                        val intent = Intent(v.context, MainActivity::class.java)
//                        v.context.startActivity(intent)
//
//                    }
//                })
//            }
//        }

    }
}
//
//
//package edu.uw.ischool.quizdroid
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.widget.*
//import android.content.Intent
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import edu.uw.ischool.quizdroid.MainActivity.Companion.INDEX
//import edu.uw.ischool.quizdroid.SecondActivity.Companion.COUNT
//import edu.uw.ischool.quizdroid.SecondActivity.Companion.Q_INDEX
////import edu.uw.ischool.quizdroid.MainActivity.Companion.OPTIONS
//import org.w3c.dom.Text
//
//class ThirdActivity : AppCompatActivity() {
//
//    companion object {
//        val CORRECT = "correct"
//        val SELECTED = "selected"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_third)
//
//        val topics = arrayOf("Math", "Physics","Marvel Super Heroes", "Movies", "Soccer", "Random")
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
//        //Subject Answers
//        val mathA = arrayOf("2", "a^2 + b^2 = c^2", "Physical Education")
//        val physicsA = arrayOf("mc^2", "3", "9.807 m/s^2")
//        val marvelA = arrayOf("Peter Parker", "Wolverine", "Walt Disney")
//        val moviesA = arrayOf("The Dark Knight", "Titanic", "The Room")
//        val soccerA = arrayOf("5", "Mo Salah", "Russia")
//        val randomA = arrayOf("Walt Disney", "The Office", "Yes")
//
//        val answers = arrayOf(mathA, physicsA, marvelA, moviesA, soccerA, randomA)
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
//                arrayOf("Hulk", "Black Widow", "Bruce Banner", "Wolverince"),
//                arrayOf("Walt Disney", "COMCAST", "FOX", "Time Warner"))
//
//        val moviesO = arrayOf(arrayOf("Dead Pool", "Forrest Gump", "The Dark Knight", "Zodiac"),
//                arrayOf("Gattaca", "Forrest Gump", "Good Will Hungting", "Titanic"),
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
//        val queNumber = findViewById(R.id.QuesNum) as TextView
//        val question = findViewById(R.id.Question) as TextView
//        val submit = findViewById(R.id.submit) as Button
//        submit.setVisibility(View.GONE)
//
//
//
//        val index = intent.getIntExtra(MainActivity.INDEX, 0)
//        var qIndex = intent.getIntExtra(SecondActivity.Q_INDEX, 0)
//        var count = intent.getIntExtra(SecondActivity.COUNT, 0)
//
//        val aSet = answers[index]
//        val qSet = questions[index]
//        val oSet = options[index][qIndex]
//
//
//        var selected = "none"
//        var correct = aSet[qIndex]
//
//
//        supportActionBar?.title = topics[index]
//
//        queNumber.setText("Question ${qIndex + 1}")
//        question.setText(qSet[qIndex])
//
//
//        val btnArray = arrayOf(R.id.radioButton,
//                R.id.radioButton2,
//                R.id.radioButton3,
//                R.id.radioButton4)
//
//
//        var optionIndex = 0
//        for (btn in btnArray) {
//            val button = findViewById(btn) as RadioButton
//            button.text = oSet[optionIndex]
//            optionIndex++
//            button.setOnClickListener {
//                submit.setVisibility(View.VISIBLE)
//                selected = button.text.toString()
//            }
//        }
//
//        submit.setOnClickListener({v ->
//            val intent = Intent(v.context, FourthActivity::class.java)
//
//            intent.putExtra(SELECTED, selected)
//            intent.putExtra(CORRECT, correct)
//            intent.putExtra(MainActivity.INDEX, index)
//            intent.putExtra(SecondActivity.Q_INDEX, qIndex)
//            intent.putExtra(SecondActivity.COUNT, count)
//
//            v.context.startActivity(intent)
//        })
//
//    }
//}