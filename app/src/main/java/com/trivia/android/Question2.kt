package com.trivia.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.trivia.android.util.TriviaConstants
import kotlinx.android.synthetic.main.activity_question2.*
import kotlinx.android.synthetic.main.activity_question2.nextButton
import kotlinx.android.synthetic.main.activity_question3.*

class Question2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        groupCricket.isSingleSelection = true

        nextButton.setOnClickListener { v -> validateSelection() }
    }


    fun validateSelection() {
        if (optionSachin.isChecked || optionVirat.isChecked || optionAdam.isChecked || optionKallis.isChecked)
            startActivity(Intent(this, Question3::class.java).putExtra(TriviaConstants.USERNAME, intent.getStringExtra(TriviaConstants.USERNAME))
                .putExtra(TriviaConstants.CRICKETER,getSelectedCricketer()))
        else
            Toast.makeText(this, "Select One Player", Toast.LENGTH_SHORT).show()
    }

    private fun getSelectedCricketer(): String? {
        if (optionSachin.isChecked) {
            return "Sachin Tendulkar"
        } else if (optionAdam.isChecked) {
            return "Adam Gilchirst"
        } else if (optionVirat.isChecked) {
            return "Virat Kolli"
        } else return "Jacques Kallis"
    }
}