package com.trivia.android.core.db

import android.content.Context
import androidx.room.*
import com.trivia.android.core.model.Report
import com.trivia.android.core.model.ReportDao


@Database(entities = arrayOf(Report::class),version = 1, exportSchema = false)
abstract class TriviaDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE:TriviaDatabase? = null
        val DATABASE_NAME = "database-trivia"

        fun initDatabase(context: Context) {
            if (null == INSTANCE)
            {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TriviaDatabase::class.java,
                    DATABASE_NAME).allowMainThreadQueries().build()
            }
        }

        fun getDatabase():TriviaDatabase? {
            return INSTANCE
        }
    }

    abstract fun reportDao(): ReportDao
}