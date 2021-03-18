package com.abhishekgupta.age.calculator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.view.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment.newInstance())
                .commitNow()
        }
    }
}