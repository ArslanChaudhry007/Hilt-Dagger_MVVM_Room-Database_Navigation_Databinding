package com.mvvm_databinding_hiltdagger.repository

import com.mvvm_databinding_hiltdagger.db.TodoDao
import com.mvvm_databinding_hiltdagger.model.Todo
import javax.inject.Inject

class TodoRepository
@Inject
constructor(private val dao: TodoDao) {
    suspend fun insertTdo(todo: Todo) = dao.insertTodo(todo)
    fun getAllToDos() = dao.getAllToDos()
    suspend fun deleteSelectTodo(todo:Todo) = dao.deleteToDo(todo)

}