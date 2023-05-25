package com.inmortal.tourmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.inmortal.tourmanager.R
import com.inmortal.tourmanager.databinding.ActivityMainBinding
import com.inmortal.tourmanager.fragment.HomeFragment
import com.inmortal.tourmanager.fragment.NotificationFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentReplace(HomeFragment())
        binding.btmMain.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    fragmentReplace(HomeFragment())
                    true
                }
                R.id.notification -> {
                    fragmentReplace(NotificationFragment())
                    true
                }
                R.id.chat -> {
                    fragmentReplace(HomeFragment())
                    true
                }
                R.id.date->{
                    fragmentReplace(HomeFragment())
                    true
                }

                else -> {
                    false
                }
            }

        }
    }

    private fun fragmentReplace(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()


    }
}