package com.zentechnology.bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        openFragment(HomeFragment.newInstance("", ""))
    }

    var navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                openFragment(HomeFragment.newInstance("", ""))
                return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_sms -> {
                    openFragment(SmsFragment.newInstance("", ""))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    openFragment(NotificationFragment.newInstance("", ""))
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
