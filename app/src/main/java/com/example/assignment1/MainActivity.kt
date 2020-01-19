/*
    Author: Jessica MacDonald
    Exercise: Android, Assignment 1
    Date: 01-19-2020
 */

package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton


class MainActivity : AppCompatActivity() {

    //Creating list with all questions for the app
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    //Creating variables for all controls and the question index
    var questionIndex = 0
    lateinit var questionView : TextView
    lateinit var nextButton : AppCompatImageButton
    lateinit var backButton : AppCompatImageButton
    lateinit var trueButton : Button
    lateinit var falseButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing all views
        questionView = findViewById(R.id.question_view)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        //Setting the question text
        questionView.setText(questionBank[questionIndex].TextResId)

        //Setting onClick Listener for all buttons on the screen
        nextButton.setOnClickListener{nextQuestion()}
        backButton.setOnClickListener{previousQuestion()}
        trueButton.setOnClickListener{isCorrectAnswer()}
        falseButton.setOnClickListener{isAnswerFalse()}

    }

    /**
     * Method going to the next question
     */
    private fun nextQuestion(){
        questionIndex = (questionIndex + 1) % 20
        questionView.setText(questionBank[questionIndex].TextResId)
    }

    /**
     * Method that goes to the previous question
     */
    private fun previousQuestion(){

        if(questionIndex == 0){
            questionIndex = questionBank.count() - 1;
        }
        else{
            questionIndex = (questionIndex - 1)
        }

        questionView.setText(questionBank[questionIndex].TextResId)

    }

    /**
     * Method Checking whether the answer is true
     */
    private fun isCorrectAnswer(){
        if(questionBank[questionIndex].answer){
            Toast.makeText(this, "Correct!!!",
                Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "YOU ARE WRONG!",
                Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Method checking whether the answer is false
     */
    private fun isAnswerFalse(){
        if(!questionBank[questionIndex].answer){
            Toast.makeText(this, "Correct!!!",
                Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "YOU ARE WRONG!",
                Toast.LENGTH_SHORT).show()
        }
    }

}
