package com.trivia.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.trivia.android.util.TriviaConstants
import kotlinx.android.synthetic.main.activity_question1.*
import kotlinx.android.synthetic.main.activity_question1.nextButton
import kotlinx.android.synthetic.main.activity_question2.*

class Question1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)

        nextButton.setOnClickListener({ v -> validateSelection()})
    }

    fun validateSelection() {
        if (editTextPersonName.text.length >= 1)
            startActivity(Intent(this, Question2::class.java).putExtra(TriviaConstants.USERNAME,editTextPersonName.text.toString()))
        else
            Toast.makeText(this, "Enter name !", Toast.LENGTH_SHORT).show()
    }
}