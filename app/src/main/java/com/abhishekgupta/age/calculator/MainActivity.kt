package com.abhishekgupta.age.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abhishekgupta.age.calculator.ui.profile.ProfileFragment

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
