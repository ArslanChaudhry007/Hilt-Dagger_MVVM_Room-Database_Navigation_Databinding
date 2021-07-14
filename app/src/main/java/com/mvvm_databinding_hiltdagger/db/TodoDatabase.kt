package com.mvvm_databinding_hiltdagger.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvvm_databinding_hiltdagger.model.Todo


@Database(entities = [Todo::class], version = 2, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}