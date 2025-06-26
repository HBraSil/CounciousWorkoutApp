package com.example.mindfulworkout.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mindfulworkout.model.WorkoutInfo


@Database(entities = [WorkoutInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao


    companion object {
        private var instance : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return if (instance == null) {
                instance = buildDatabase(context)
                instance!!
            } else {
                instance!!
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "workout_database"
            ).build()
        }
    }
}