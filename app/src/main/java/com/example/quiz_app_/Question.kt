package com.example.quiz_app_

data class Question(
    val id: Int,
    val questions: String,
    val image: Int,
    val optionZero:String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer: Int,
)
