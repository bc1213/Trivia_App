package com.trivia.android.core.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ReportDao {
    @Insert
    fun insertAll(vararg report: Report)

    @Delete
    fun delete(report: Report)

    @Query("SELECT * FROM Report")
    fun getAllReports(): List<Report>

    @Query("DELETE  FROM Report")
    fun clearTable()
}