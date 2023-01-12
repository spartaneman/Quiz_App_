package com.example.quiz_app_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var tvProgressbar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvAnswerZero: TextView? = null
    private var tvAnswerOne: TextView? = null
    private var tvAnswerTwo: TextView? = null
    private var tvAnswerThree: TextView? = null
    private var tvAnswerFour: TextView? = null

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

        val questionList = Constants.getQuestions()
        var currentPosition = 0

        val question: Question = questionList[currentPosition]

        //since the image is saved as an int
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgressbar?.text = "${currentPosition + 1} / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvAnswerZero?.text = question.optionZero
        tvAnswerOne?.text = question.optionOne
        tvAnswerTwo?.text = question.optionTwo
        tvAnswerThree?.text = question.optionThree
        tvAnswerFour?.text = question.optionFour

    }
}