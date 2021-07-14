package com.mvvm_databinding_hiltdagger.activities.fragments

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mvvm_databinding_hiltdagger.R
import com.mvvm_databinding_hiltdagger.databinding.FragmentAddTodoBinding
import com.mvvm_databinding_hiltdagger.model.Todo
import com.mvvm_databinding_hiltdagger.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddTodoFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentAddTodoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnCancel.setOnClickListener(this)
        binding.btnAddTodo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.btnCancel -> {
              view?.findNavController()?.navigate(
                  R.id.action_addTodoFragment_to_todoListFragment
              )
            }

            R.id.btnAddTodo -> {
              saveTodo(v)
            }
        }
    }

    private fun saveTodo(view: View) {
        val todoName = binding.etTodoTitle.text.toString()
        if (todoName.isNotEmpty()){
            val todo = Todo(0,todoName)
            viewModel.insertTodo(todo)
            Snackbar.make(view,"Todo Added", Snackbar.LENGTH_SHORT).show()

            view.findNavController().navigate(
                R.id.action_addTodoFragment_to_todoListFragment
            )
        } else {
           val toast = Toast.makeText(activity,"Todo title cannot be empty", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()

        }
    }

}