package com.example.mindfulworkout.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mindfulworkout.App
import com.example.mindfulworkout.compose.MainScreen
import com.example.mindfulworkout.data.WorkoutInfoRepository
import com.example.mindfulworkout.model.WorkoutInfo
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val repository: WorkoutInfoRepository
) : ViewModel() {

    fun saveWorkoutInfo(workoutInfo: WorkoutInfo) {
        viewModelScope.launch {
            repository.insertExercise(workoutInfo)
        }
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = extras[APPLICATION_KEY]
                val dao = (application as App).db.exerciseDao()
                val repository = WorkoutInfoRepository.getInstance(dao)

                return MainScreenViewModel(repository) as T
            }
        }
    }


}
