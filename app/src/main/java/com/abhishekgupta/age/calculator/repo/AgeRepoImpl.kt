package com.abhishekgupta.age.calculator.repo

import com.abhishekgupta.age.calculator.model.Age
import com.abhishekgupta.age.calculator.model.calculateAge
import java.text.SimpleDateFormat
import java.util.*

class AgeRepoImpl : IAgeRepo {
    override suspend fun calculateAge(dob: String): Age? {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        val birthDate: Date? = sdf.parse(dob)
        return birthDate?.calculateAge()
    }

}