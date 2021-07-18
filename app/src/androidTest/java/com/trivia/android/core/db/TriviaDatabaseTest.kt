package com.trivia.android.core.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Root
import androidx.test.runner.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.trivia.android.core.model.Report
import com.trivia.android.core.model.ReportDao
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class TriviaDatabaseTest : TestCase() {

    private lateinit var db: TriviaDatabase

    private lateinit var dao: ReportDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, TriviaDatabase::class.java).build()

        dao = db.reportDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadDBEntries() {
        val date = Date()
        val entry = Report(date.toString(),"Bharath","Dhoni","Blue")
        dao.insertAll(entry)
        val reportsFetch = dao.getAllReports()
        assertThat(reportsFetch.contains(entry)).isTrue()
    }

}