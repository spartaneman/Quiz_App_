package com.example.quiz_app_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val userScore = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        val tvName: TextView = findViewById(R.id.tvName)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnFinish: Button = findViewById(R.id.btnFinish)

        tvName.text = userName
        tvScore.text = "Your Score is\n${userScore}/$totalQuestions"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}