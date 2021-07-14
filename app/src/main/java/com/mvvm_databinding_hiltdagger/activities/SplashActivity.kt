package com.mvvm_databinding_hiltdagger.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mvvm_databinding_hiltdagger.R
import com.mvvm_databinding_hiltdagger.utility.navigate

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToMainActivity()
    }

    private fun moveToMainActivity() {
        Handler().postDelayed({
            navigate<MainActivity>()
        }, 3000)
    }
}