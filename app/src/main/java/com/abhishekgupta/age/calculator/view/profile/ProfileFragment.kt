package com.abhishekgupta.age.calculator.view.profile

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.databinding.ProfileFragmentBinding
import com.abhishekgupta.age.calculator.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.profile_fragment.*
import java.util.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        binding.dob.setOnClickListener {
            val today = Calendar.getInstance()
            val currentDay = today.get(Calendar.DAY_OF_MONTH)
            val currentMonth = today.get(Calendar.MONTH)
            val currentYear = today.get(Calendar.YEAR)

            DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    binding.dob.text = getString(R.string.date_format, day, month + 1, year)
                },
                currentYear,
                currentMonth,
                currentDay
            ).show()

        }

        nextButton.setOnClickListener {

        }
    }

}
