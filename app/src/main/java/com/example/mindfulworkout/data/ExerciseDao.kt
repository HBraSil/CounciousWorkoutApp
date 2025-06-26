package com.example.mindfulworkout.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mindfulworkout.model.WorkoutInfo

@Dao
interface ExerciseDao {
    @Insert()
    suspend fun insert(exercise: WorkoutInfo)

    @Query("SELECT * FROM workout_table")  // O ERRO PODE ESTAR AQUI
    suspend fun getExercisesInfo(): List<WorkoutInfo>
}