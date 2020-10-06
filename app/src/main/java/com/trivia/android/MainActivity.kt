package com.trivia.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trivia.android.util.TriviaConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username.setText("Hello, "+ intent.getStringExtra(TriviaConstants.USERNAME))

        asnCricket.setText(" "+ intent.getStringExtra(TriviaConstants.CRICKETER))

        asnFlag.setText(" "+ intent.getStringExtra(TriviaConstants.COLORFLAG))

        finish.setOnClickListener { view -> launchFresh() }
    }

    private fun launchFresh() {
        startActivity(Intent(this,Question1::class.java))
        finish()
    }
}