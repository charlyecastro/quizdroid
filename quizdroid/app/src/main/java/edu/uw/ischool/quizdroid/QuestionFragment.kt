package edu.uw.ischool.quizdroid

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Bundle
import android.util.Log
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

    companion object {
        val SELECTED = "selected"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //getRepo
        val app = QuizApp()
        val repo = app.getRepository()
        val topics = repo.getTopics()

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
        question.text = topics[index].quiz.questions!![qIndex]


        val btnArray = arrayOf(R.id.radioButton,
        R.id.radioButton2,
        R.id.radioButton3,
        R.id.radioButton4)

        var optionIndex = 0

        for (btn in btnArray) {
            val button = result?.findViewById(btn) as RadioButton
            button.text = topics[index].quiz.options!![qIndex][optionIndex]
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


