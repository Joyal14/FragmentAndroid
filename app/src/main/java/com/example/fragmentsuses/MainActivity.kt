package com.example.fragmentsuses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentsuses.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //when the app is loaded it will show home as selected
        replaceFragments(Home())

        //when i item is clicked it will get replace with the that fragments
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragments(Home())
                R.id.search -> replaceFragments(Search())
                R.id.profile -> replaceFragments(Profile())
                else -> {}
            }
            true
        }

    }

    private fun replaceFragments(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentManager.findFragmentById(R.id.frame_layout)
        fragmentTransaction.commit()
    }
}