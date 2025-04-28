package com.example.consciousworkout.model

data class User(
    var name: String? = null,
    var age: Int? = null,
    var weight: Double? = null,
    var height: Double? = null,
    var gender: Gender? = null
)
