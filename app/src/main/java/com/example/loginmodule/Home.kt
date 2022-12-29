package com.example.loginmodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity


class Home : Fragment() {


    private lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val activity = activity as AppCompatActivity
        val actionBar = activity.supportActionBar

        val drawerlayout : DrawerLayout = view.findViewById(R.id.drawer_layout)
        val navview : NavigationView = view.findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(activity,drawerlayout,R.string.open,R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        actionBar?.setDisplayHomeAsUpEnabled(true)

        navview.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.mutual_funds -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.Systematic_plans -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.nominee -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.calculator -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.stocks -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.ipo -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.insights -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.talk_to_us -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.reach_us -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.referals -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(activity,"Redirecting",Toast.LENGTH_SHORT).show()

                else -> {

                }
            }
            true
        }

        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)) {

            return true

         }

        return super.onOptionsItemSelected(item)
    }

}

