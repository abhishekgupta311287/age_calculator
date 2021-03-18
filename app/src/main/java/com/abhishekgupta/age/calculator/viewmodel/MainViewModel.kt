package com.abhishekgupta.age.calculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishekgupta.age.calculator.model.UserInfo
import com.abhishekgupta.age.calculator.repo.IAgeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repo: IAgeRepo) : ViewModel() {
    val ageLiveData:MutableLiveData<UserInfo> = MutableLiveData()

    fun calculateAge(firstName:String, lastName:String, dob:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val age = repo.calculateAge(dob)
            ageLiveData.postValue(UserInfo(firstName, lastName, age))
        }
    }
}
