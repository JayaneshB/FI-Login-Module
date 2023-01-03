package com.example.loginmodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.loginmodule.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("lifecycle","created")

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragments(Home())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) { 
                R.id.home -> replaceFragments(Home())
                R.id.profile -> replaceFragments(Profile())
                R.id.settings -> replaceFragments(Settings())
                else -> {
                }
            }
            true
        }
    }


    private fun replaceFragments(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}

