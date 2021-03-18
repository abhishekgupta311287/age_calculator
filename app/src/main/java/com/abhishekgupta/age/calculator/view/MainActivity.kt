package com.abhishekgupta.age.calculator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.view.age.AgeFragment
import com.abhishekgupta.age.calculator.view.profile.ProfileFragment
import com.abhishekgupta.age.calculator.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment.newInstance())
                .commit()
        }

        viewModel.ageLiveData.observe(this, {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AgeFragment.newInstance())
                .addToBackStack("AgeFragment")
                .commit()
        })
    }
}
