package edu.uw.ischool.quizdroid

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import edu.uw.ischool.quizdroid.MainActivity.Companion.DESCRIPTION
import edu.uw.ischool.quizdroid.MainActivity.Companion.INDEX
import edu.uw.ischool.quizdroid.MainActivity.Companion.NUMQ
import edu.uw.ischool.quizdroid.MainActivity.Companion.TOPIC

class OverviewFragment : Fragment() {

    companion object {
        val Q_INDEX = "qIndex"
        val COUNT = "count"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val result = inflater?.inflate(R.layout.overview_fragment,container,false)


        val topicName = result?.findViewById(R.id.topicName) as TextView
        val topic = arguments!!.getString(TOPIC)
        topicName.text = topic

        val topicDesc = result?.findViewById(R.id.topicDesc) as TextView
        topicDesc.text = arguments!!.getString(DESCRIPTION)

        val index = arguments!!.getInt(INDEX)
        val numQ = arguments!!.getInt(NUMQ)

        val begin = result.findViewById(R.id.begin) as Button

        val numQText = result.findViewById(R.id.numQ) as TextView
        numQText.text =  "Number of Questions: " + numQ

        begin.setOnClickListener({
            val fragment = QuestionFragment()
            val transaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putInt(INDEX,index)
            bundle.putInt(COUNT, 0)
            bundle.putInt(Q_INDEX, 0)
            fragment.arguments = bundle
            transaction.replace(R.id.fragment, fragment)
            transaction.commit()
        })
     return result
    }

}