package com.example.loginmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.loginmodule.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragments(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.home     -> replaceFragments(Home())
                R.id.profile   -> replaceFragments(Profile())
                R.id.settings  -> replaceFragments(Settings() )

                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragments (fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()

    }
}