package com.example.projetobottomnav

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.model.AdapterClass
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobottomnav.databinding.ActivityMainBinding
import com.example.projetobottomnav.fragments.CartFragment
import com.example.projetobottomnav.fragments.FavFragment
import com.example.projetobottomnav.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeFragment = HomeFragment()
        val favFragment = FavFragment()
        val cartFragment = CartFragment()
        setCurrentFrag(homeFragment)
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home ->{
                    setCurrentFrag(homeFragment)
                    Log.i(TAG, "Home Selected")
                }
                R.id.bottom_favorite ->{
                    setCurrentFrag(favFragment)
                    Log.i(TAG, "Fav Selected")
                }
                R.id.bottom_cart ->{
                    setCurrentFrag(cartFragment)
                    Log.i(TAG, "Cart Selected")
                }
            }
            true
        }
    }
    private fun setCurrentFrag(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_container,fragment)
            commit()
        }
}