package com.example.android4lesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.android4lesson1.databinding.FragmentTaskBinding
import com.example.android4lesson1.ui.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            setFragmentResult(
                FRAGMENT_RESULT,
                bundleOf(TASK_KEY to Task(binding.etTitle.text.toString(), binding.etDescription.text.toString()))
            )
            findNavController().navigateUp()
        }
    }

    companion object{
        const val FRAGMENT_RESULT = "tf_result"
        const val TASK_KEY = "task.key"

    }

}