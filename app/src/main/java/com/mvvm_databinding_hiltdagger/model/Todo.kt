package com.mvvm_databinding_hiltdagger.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    val todoTitle:String

)