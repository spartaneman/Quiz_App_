package com.example.quiz_app_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

//adding the View.OnClickListener to allow selection of textview
//Must implement override of onClick
class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedAnswer: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgressbar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvAnswerZero: TextView? = null
    private var tvAnswerOne: TextView? = null
    private var tvAnswerTwo: TextView? = null
    private var tvAnswerThree: TextView? = null
    private var tvAnswerFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgressbar = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivFlag)
        tvAnswerZero = findViewById(R.id.tvOptionZero)
        tvAnswerOne = findViewById(R.id.tvOptionOne)
        tvAnswerTwo = findViewById(R.id.tvOptionTwo)
        tvAnswerThree = findViewById(R.id.tvOptionThree)
        tvAnswerFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.submitBtn)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    private fun setQuestion()
    {
        //!! is the not-null operator that converts any value to a non-null type.
        val question: Question = mQuestionsList!![mCurrentPosition]

        //since the image is saved as an int
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressbar?.text = "${mCurrentPosition + 1} / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvAnswerZero?.text = question.optionZero
        tvAnswerOne?.text = question.optionOne
        tvAnswerTwo?.text = question.optionTwo
        tvAnswerThree?.text = question.optionThree
        tvAnswerFour?.text = question.optionFour
    }
}