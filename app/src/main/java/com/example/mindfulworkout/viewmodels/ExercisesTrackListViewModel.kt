package com.example.mindfulworkout.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mindfulworkout.App
import com.example.mindfulworkout.data.WorkoutInfoRepository
import com.example.mindfulworkout.model.WorkoutInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExercisesTrackListViewModel(private val repository: WorkoutInfoRepository) : ViewModel() {
    private val _exercises = MutableStateFlow<List<WorkoutInfo>>(emptyList())
    val exercises: StateFlow<List<WorkoutInfo>> = _exercises.asStateFlow()

    init {
        viewModelScope.launch {
            val lista = repository.getExercises()
            _exercises.value = lista
            Log.i("TAG", "lista: ${lista[0].exerciseName} ${lista[0].weight} ${lista[0].rep} ${lista[0].set}")
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = extras[APPLICATION_KEY]
                val dao = (application as App).db.exerciseDao()
                val repository = WorkoutInfoRepository.getInstance(dao)

                return ExercisesTrackListViewModel(repository) as T
            }
        }
    }
}
