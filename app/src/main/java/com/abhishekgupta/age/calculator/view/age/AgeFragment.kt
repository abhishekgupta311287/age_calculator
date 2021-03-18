package com.abhishekgupta.age.calculator.view.age

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abhishekgupta.age.calculator.R
import com.abhishekgupta.age.calculator.databinding.AgeFragmentBinding
import com.abhishekgupta.age.calculator.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AgeFragment : Fragment() {

    companion object {
        fun newInstance() = AgeFragment()
    }

    private val viewModel by sharedViewModel<MainViewModel>()
    private var _binding: AgeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AgeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.ageLiveData.observe(viewLifecycleOwner, {
            binding.age.text = getString(R.string.age_format, it.firstName, it.lastName, it.age)
        })
    }

}
