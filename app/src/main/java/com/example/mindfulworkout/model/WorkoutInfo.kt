package com.example.mindfulworkout.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

@Entity(tableName = "workout_table")
data class WorkoutInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var exerciseName: String = "",
    var weight: String = "",
    var rep: String = "",
    var set: String = ""
)
