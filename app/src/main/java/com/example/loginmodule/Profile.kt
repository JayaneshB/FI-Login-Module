package com.example.loginmodule

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("lifecycle","destroyed")
//        Toast.makeText(activity,"Process destroyed", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("lifecycle","started")
//        Toast.makeText(activity,"Process started",Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("lifecycle","resume")
//        Toast.makeText(activity,"Process resumed",Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("lifecycle","paused")
//        Toast.makeText(activity,"Process paused",Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("lifecycle","stoped")
//        Toast.makeText(activity,"Process stoped",Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d("lifecycle","destroyview")
//        Toast.makeText(activity,"Process destroy view",Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.d("lifecycle","detached")
//        Toast.makeText(activity,"Process detached",Toast.LENGTH_SHORT).show()
//    }
//

}
