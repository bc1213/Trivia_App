package com.trivia.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.trivia.android.core.db.TriviaDatabase
import com.trivia.android.core.model.Report
import com.trivia.android.util.TriviaConstants
import kotlinx.android.synthetic.main.activity_question3.*
import java.text.DateFormat
import java.util.*

class Question3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        groupColors.isSingleSelection = false

        nextButton.setOnClickListener { view ->  validateSelection()}
    }

    fun validateSelection() {
        if (optionGreen.isChecked || optionWhite.isChecked || optionOrange.isChecked || optionYellow.isChecked) {
            startActivity(Intent(this, MainActivity::class.java).putExtra(TriviaConstants.USERNAME, intent.getStringExtra(TriviaConstants.USERNAME))
                .putExtra(TriviaConstants.CRICKETER,intent.getStringExtra(TriviaConstants.CRICKETER))
                .putExtra(TriviaConstants.COLORFLAG, getSelectedColors()))
            saveToDB()
        }
        else
            Toast.makeText(this, "Select Colors",Toast.LENGTH_SHORT).show()
    }

    private fun saveToDB() {
        val data = intent.getStringExtra(TriviaConstants.USERNAME)?.let {
            getSelectedColors()?.let { it1 ->
                Report(userName = it, colorSelected = it1,
                    crickter = intent.getStringExtra(TriviaConstants.CRICKETER)!!, dateTime = TriviaConstants.dateformat.format(Calendar.getInstance().time).toString())
            }
        }

        data?.let { TriviaDatabase.getDatabase()?.reportDao()?.insertAll(it) }
    }

    fun getSelectedColors(): String? {
        var result = ""

        if (optionGreen.isChecked) {
            result = result + "Green,"
        }

        if (optionWhite.isChecked) {
            result = result + "White,"
        }

        if (optionOrange.isChecked) {
            result = result + "Orange,"
        }

        if (optionYellow.isChecked) {
            result = result + "Yellow"
        }

        return result

    }
}