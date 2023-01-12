package com.example.quiz_app_

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

//adding the View.OnClickListener to allow selection of textview
//Must implement override of onClick
class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    //Control values of the current questions and questions
    private var mCurrentPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedAnswer: Int = -1

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

        //must set the textviews to onClickListeners
        tvAnswerZero?.setOnClickListener(this)
        tvAnswerOne?.setOnClickListener(this)
        tvAnswerTwo?.setOnClickListener(this)
        tvAnswerThree?.setOnClickListener(this)
        tvAnswerFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        defaultAnswersView()
    }

    //Must override to create the Textviews to be selectable
    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.tvOptionZero -> {
                tvAnswerZero?.let {
                    selectedAnswerView(it, 0)
                }
            }

            R.id.tvOptionOne -> {
                tvAnswerOne?.let {
                    selectedAnswerView(it, 1)
                }
            }
            R.id.tvOptionTwo -> {
                tvAnswerTwo?.let {
                    selectedAnswerView(it, 2)
                }
            }
            R.id.tvOptionThree -> {
                tvAnswerThree?.let {
                    selectedAnswerView(it, 3)
                }
            }
            R.id.tvOptionFour -> {
                tvAnswerFour?.let {
                    selectedAnswerView(it, 4)
                }
            }
            R.id.submitBtn ->{
                //This checks that an answer has been chosen since mSelectedAnswer will be reset to
                //-1 after answering the question
                if(mSelectedAnswer == -1)
                {
                    mCurrentPosition++

                    //Here we will set the textviews to match the current question as
                    //long as the list contains questions
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                    }
                }else
                {
                    //else we are going to check the the answer is correct or not
                    val question = mQuestionsList?.get(mCurrentPosition)
                    //if the value matches what was selected then the text view will turn green and
                    //red if incorrect
                    if(question!!.correctAnswer != mSelectedAnswer)
                    {
                        answerView(mSelectedAnswer, R.drawable.wrong_answer_background)
                    }
                    mSelectedAnswer=-1
                    if(mCurrentPosition == mQuestionsList!!.size-1)
                    {
                        btnSubmit?.setText("Finish")
                    }
                    else
                    {
                        btnSubmit?.setText("Next Question")
                    }

                }
            }
        }
    }

    //change the view passing in the answer location and background
    private fun answerView(answer: Int, drawableView: Int)
    {
        when(answer)
        {
            0-> {
                tvAnswerZero?.background = ContextCompat.getDrawable(this, drawableView)
            }
            1-> {
                tvAnswerOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2-> {
                tvAnswerTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3-> {
                tvAnswerThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4-> {
                tvAnswerFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    //This function creates the default look of the textview buttons.
    private fun defaultAnswersView()
    {
        val answers = ArrayList<TextView>()
        //To add the textviews into the arrayList we must use the let
        //since the variables are null to begin with
        tvAnswerZero?.let {
            answers.add(0,it)
        }
        tvAnswerOne?.let {
            answers.add(1,it)
        }
        tvAnswerTwo?.let {
            answers.add(2,it)
        }
        tvAnswerThree?.let {
            answers.add(3,it)
        }
        tvAnswerFour?.let {
            answers.add(4,it)
        }

        for(answer in answers)
        {
            //This will be the default options
            //Not sure what the ContextCompat is.
            answer.setTextColor(Color.parseColor("#8A2308"))
            answer.typeface = Typeface.DEFAULT
            answer.background = ContextCompat.getDrawable(this,R.drawable.answer_textview)
        }
    }

    //This function will change the view of the selected textview
    private fun selectedAnswerView(tView: TextView, selectedAnswerValue: Int)
    {
        //This will turn all the Textviews back to normal
        defaultAnswersView()

        mSelectedAnswer = selectedAnswerValue

        //Here we change the textview of the selected textview
        tView.setTextColor(Color.parseColor("#363A43"))
        tView.setTypeface(tView.typeface, Typeface.BOLD)
        tView.background = ContextCompat.getDrawable(this, R.drawable.selected_border_background)
    }

    //this will set the text and images according to the current position in the question ArrayList
    private fun setQuestion()
    {
        defaultAnswersView()
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

        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "Finish"
        }else{
            btnSubmit?.text = "Submit"
        }

    }
}