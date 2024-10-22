package com.example.dbms

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var homenavbar: ImageView
    private lateinit var profileImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_home_activity)

        // Initialize BottomNavigationView
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Initialize ImageViews for the header
        homenavbar = findViewById(R.id.homenavbar)
        profileImage = findViewById(R.id.profile_image)

        // Set listener for BottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        // Set default fragment when the activity starts
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
        }

        // Set click listeners for header icons
        homenavbar.setOnClickListener {
            // Handle navbar icon click (e.g., open a drawer)
            // Implement your navigation drawer logic here
        }

        profileImage.setOnClickListener {
            // Handle profile image click (e.g., open profile activity)
            // Implement your profile logic here
        }
    }

    // Bottom Navigation listener to switch between fragments
    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_search -> selectedFragment = SearchFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
            }

            // Begin the fragment transaction
            selectedFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, it)
                    .commit()
            }
            true
        }
}
