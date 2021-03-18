package com.abhishekgupta.age.calculator.view.profile

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.databinding.ProfileFragmentBinding
import com.abhishekgupta.age.calculator.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel by sharedViewModel<MainViewModel>()
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

        binding.dob.setOnClickListener {
            val today = Calendar.getInstance()
            val currentDay = today.get(Calendar.DAY_OF_MONTH)
            val currentMonth = today.get(Calendar.MONTH)
            val currentYear = today.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    binding.dob.text = getString(R.string.date_format, day, month + 1, year)
                },
                currentYear,
                currentMonth,
                currentDay
            )
            datePickerDialog.datePicker.maxDate = today.timeInMillis
            datePickerDialog.show()

        }

        binding.nextButton.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val dob = binding.dob.text.toString()
            if (isValidInput(firstName, lastName, dob)) {
                viewModel.calculateAge(
                    firstName,
                    lastName,
                    dob
                )
            }

        }
    }

    private fun isValidInput(firstName: String, lastName: String, dob: String) =
        when {
            firstName.isEmpty() -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.hint_first_name),
                    Toast.LENGTH_LONG
                )
                    .show()
                false
            }
            lastName.isEmpty() -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.hint_last_name),
                    Toast.LENGTH_LONG
                )
                    .show()
                false
            }
            dob.isEmpty() -> {
                Toast.makeText(requireContext(), getString(R.string.hint_dob), Toast.LENGTH_LONG)
                    .show()
                false
            }
            else -> {
                true
            }
        }

}
