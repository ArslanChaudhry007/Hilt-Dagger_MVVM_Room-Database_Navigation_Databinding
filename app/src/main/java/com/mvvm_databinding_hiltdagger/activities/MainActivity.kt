package com.mvvm_databinding_hiltdagger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ActionBarContextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.mvvm_databinding_hiltdagger.R
import com.mvvm_databinding_hiltdagger.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration:AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        navController = navHostFrag.navController
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.todoListFragment,
//                R.id.addTodoFragment
//            )
//        )

    }
}