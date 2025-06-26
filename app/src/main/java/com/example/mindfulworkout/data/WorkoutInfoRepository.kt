package com.example.mindfulworkout.data

import com.example.mindfulworkout.model.WorkoutInfo

class WorkoutInfoRepository(private val exerciseDao: ExerciseDao) {
    suspend fun insertExercise(exercise: WorkoutInfo) {
        exerciseDao.insert(exercise)
    }

    suspend fun getExercises(): List<WorkoutInfo> {
        return exerciseDao.getExercisesInfo()
    }

    companion object {
        private var instance: WorkoutInfoRepository? = null

        fun getInstance(exerciseDao: ExerciseDao): WorkoutInfoRepository {
            return instance ?: WorkoutInfoRepository(exerciseDao).also {
                instance = it
            }
        }
    }
}