package com.mvvm_databinding_hiltdagger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mvvm_databinding_hiltdagger.model.Todo
import com.mvvm_databinding_hiltdagger.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TodoViewModel
@Inject
constructor(private val todoRepository: TodoRepository): ViewModel() {


    fun  insertTodo(todo: Todo) = viewModelScope.launch {
        todoRepository.insertTdo(todo)
    }

    fun  deleteTodo(todo: Todo) = viewModelScope.launch {
        todoRepository.deleteSelectTodo(todo)
    }

    val getAllToDos = todoRepository.getAllToDos().asLiveData()
}