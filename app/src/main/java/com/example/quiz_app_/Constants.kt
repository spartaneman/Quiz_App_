package com.example.quiz_app_

object Constants {

    //these will be the keys
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q0 = Question(0,"What country does this flag belong to?",R.drawable.ic_flag_of_argentina,
        "Argentina", "Australia","Israel", "Austria","Dominican Republic",
        0)
        questionsList.add(q0)

        //
        val q1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia",
            "Wales", 1
        )

        questionsList.add(q1)

        //
        val q2 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", "Portugal",3
        )

        questionsList.add(q2)

        //
        val q3 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", "Beirut", 1
        )

        questionsList.add(q3)

        //
        val q4 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland","Florida", 2
        )

        questionsList.add(q4)

        //
        val q5 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "Italy","Russia", 0
        )

        questionsList.add(q5)

        //
        val q6 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia","Sweden", 2
        )

        questionsList.add(q6)

        //
        val q7 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India","Mexico", 3
        )

        questionsList.add(q7)

        //
        val q8 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America","Austria", 1
        )

        questionsList.add(q8)

        //
        val q9 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine","Iraq", 0
        )

        questionsList.add(q9)

        return questionsList
    }
}