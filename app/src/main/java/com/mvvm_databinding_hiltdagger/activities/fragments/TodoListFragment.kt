package com.mvvm_databinding_hiltdagger.activities.fragments

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mvvm_databinding_hiltdagger.R
import com.mvvm_databinding_hiltdagger.adapter.TodoAdapter
import com.mvvm_databinding_hiltdagger.databinding.FragmentTodoListBinding
import com.mvvm_databinding_hiltdagger.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm_databinding_hiltdagger.`interface`.GenericCallBackAdapter
import com.mvvm_databinding_hiltdagger.model.Todo


@AndroidEntryPoint
class TodoListFragment : Fragment(R.layout.fragment_todo_list), View.OnClickListener {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoViewModel by viewModels()
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        setUpRecyclerViewData()
    }


    private fun initListeners() {
        binding.faAddTodo.setOnClickListener(this)
    }

    private fun setUpRecyclerViewData() {
          todoAdapter = TodoAdapter()
        binding.rvListTodo.apply {
            adapter = todoAdapter
            setHasFixedSize(true)
        }

        viewModel.getAllToDos.observe(requireActivity()) { listTodo ->
            updateUi(listTodo)
            todoAdapter.mTodo = listTodo
        }





    }

    private fun updateUi(list: List<Todo>) {
        if (list.isNotEmpty()) {
            binding.rvListTodo.visibility = View.VISIBLE
            binding.cardviewTv.visibility = View.GONE
        } else {
            binding.rvListTodo.visibility = View.GONE
            binding.cardviewTv.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.faAddTodo -> {
                view?.findNavController()?.navigate(
                    R.id.action_todoListFragment_to_addTodoFragment
                )
            }
        }
    }

}