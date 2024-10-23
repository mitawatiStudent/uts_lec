package com.example.test1

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.test1.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        // Load the first fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnBoarding1Fragment())
                .commit()
        }

        // Handle back pressed event
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Check if there are any fragments in the back stack
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack() // Pop the back stack
                } else {
                    finish() // Finish the activity if there are no fragments to pop
                }
            }
        })
//        // After completing the onboarding
//        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putBoolean("is_onboarded", true)
//        editor.apply()
//
//        // Navigate to LoginActivity
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
    }

    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // This allows you to go back
            .commit()
    }
}