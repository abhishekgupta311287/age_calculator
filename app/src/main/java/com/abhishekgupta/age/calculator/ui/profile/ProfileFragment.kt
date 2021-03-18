package com.abhishekgupta.age.calculator.ui.profile

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.databinding.ProfileFragmentBinding
import kotlinx.android.synthetic.main.profile_fragment.*
import java.util.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()

        const val HANDLER_DELAY = 2000L
    }

    private lateinit var viewModel: MainViewModel
    private val handler = Handler()
    private var runnable: Runnable? = null
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

            binding.datePicker.init(
                currentYear,
                currentMonth,
                currentDay
            ) { view, year, month, day ->

                runnable?.let {
                    handler.removeCallbacks(it)
                }
                runnable = Runnable {
                    binding.dob.text = getString(R.string.date_format, day, month, year)
                    binding.datePicker.visibility = View.INVISIBLE
                }
                handler.postDelayed(runnable!!, HANDLER_DELAY)

            }
            binding.datePicker.visibility = View.VISIBLE
        }

        nextButton.setOnClickListener {

        }
    }

}
