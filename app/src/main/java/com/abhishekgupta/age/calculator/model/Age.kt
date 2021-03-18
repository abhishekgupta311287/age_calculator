package com.abhishekgupta.age.calculator.model

import java.util.*

data class Age(
    val days: Int,
    val months: Int,
    val years: Int
) {
    override fun toString(): String {
        return "$years Years, $months Months, $days Days"
    }
}

fun Date.calculateAge(): Age {
    var years: Int
    var months: Int
    val days: Int

    //create calendar object for birth day
    val birthDay: Calendar = Calendar.getInstance()
    birthDay.timeInMillis = this.time

    //create calendar object for current day
    val currentTime = System.currentTimeMillis()
    val now: Calendar = Calendar.getInstance()
    now.timeInMillis = currentTime

    //Get difference between years
    years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR)
    val currMonth: Int = now.get(Calendar.MONTH) + 1
    val birthMonth: Int = birthDay.get(Calendar.MONTH) + 1

    //Get difference between months
    months = currMonth - birthMonth

    //if month difference is in negative then reduce years by one
    //and calculate the number of months.
    if (months < 0) {
        years--
        months = 12 - birthMonth + currMonth
        if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) months--
    } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
        years--
        months = 11
    }

    //Calculate the days
    if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
        days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE)
    else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
        val today: Int = now.get(Calendar.DAY_OF_MONTH)
        now.add(Calendar.MONTH, -1)
        days =
            now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today
    } else {
        days = 0
        if (months == 12) {
            years++
            months = 0
        }
    }
    return Age(days, months, years)
}
