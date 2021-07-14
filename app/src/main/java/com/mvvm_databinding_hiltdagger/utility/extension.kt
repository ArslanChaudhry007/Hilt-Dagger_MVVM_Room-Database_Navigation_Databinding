package com.mvvm_databinding_hiltdagger.utility

import android.app.Activity
import android.content.Intent

//Navigate from One activity to Another and Clear Previous activities
inline fun <reified T : Activity> Activity.navigate(
    finish: Boolean = true,
    anim: String = "",
    clear: Boolean = true
) {
    val intent = Intent(this, T::class.java)
    if (clear) {
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
    }
    startActivity(intent)
    if (finish) {
        finish()
    }

//    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}