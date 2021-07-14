package com.mvvm_databinding_hiltdagger.db


import androidx.room.*
import com.mvvm_databinding_hiltdagger.model.Todo
import kotlinx.coroutines.flow.Flow



@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteToDo(toDo: Todo)

    @Query("SELECT * FROM todo ORDER BY toDoTitle ASC ")
    fun getAllToDos(): Flow<List<Todo>>
}