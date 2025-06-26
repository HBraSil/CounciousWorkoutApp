package com.example.mindfulworkout.model

import androidx.room.TypeConverter
import java.util.Date


class Converters {
    // DATE => NUMERO(long)
    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }

    // NUMERO(long) => DATE
    @TypeConverter
    fun timestampToDate(time: Long): Date {
        return Date(time)
    }
}
