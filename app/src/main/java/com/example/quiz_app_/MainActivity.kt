package com.example.quiz_app_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val etxName: EditText = findViewById(R.id.etxName)

        startBtn.setOnClickListener {
            if(etxName.text.isEmpty())
            {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show()
            }
            else
            {
                //intent states what action we wish to perform
                //We must start it for it to work
                val intent = Intent(this, QuizQuestionActivity::class.java)
                //this allows me to send data to the next activity
                intent.putExtra(Constants.USER_NAME, etxName.text.toString())
                startActivity(intent)
                //this will close the application and if we go back will
                //start a new instance of the application
                finish()
            }
        }


    }
}