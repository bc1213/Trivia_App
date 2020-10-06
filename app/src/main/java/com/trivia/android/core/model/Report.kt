package com.trivia.android.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Report (
    @PrimaryKey
    @ColumnInfo(name = "datetime") val dateTime: String,
    @ColumnInfo(name = "username") val userName: String,
    @ColumnInfo(name = "crickter") val crickter: String,
    @ColumnInfo(name = "colorSelected") val colorSelected: String
)