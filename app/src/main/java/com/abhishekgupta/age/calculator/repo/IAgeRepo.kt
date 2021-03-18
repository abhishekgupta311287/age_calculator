package com.abhishekgupta.age.calculator.repo

import com.abhishekgupta.age.calculator.model.Age

interface IAgeRepo {
    suspend fun calculateAge(dob:String) : Age?
}