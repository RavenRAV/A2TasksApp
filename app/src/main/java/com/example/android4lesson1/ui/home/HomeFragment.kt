package com.example.android4lesson1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android4lesson1.R
import com.example.android4lesson1.TaskFragment
import com.example.android4lesson1.databinding.FragmentHomeBinding
import com.example.android4lesson1.ui.Task
import com.example.android4lesson1.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerHome.adapter = adapter
        setFragmentResultListener(TaskFragment.FRAGMENT_RESULT){ key, bundle ->
            val task = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            adapter.addTask(task)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}