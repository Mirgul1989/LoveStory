package com.example.lovestory.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.lovestory.R
import com.example.lovestory.data.Pref
import com.example.lovestory.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var pref: Pref
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = Pref(this)
        val navController = findNavController(R.id.nav_host_fragment)

        if (!pref.isOnBoardingShow())
            navController.navigate(R.id.onBoardingFragment)


        AppBarConfiguration(
            setOf(
                R.id.firstFragment,
                R.id.loveFragment1,
                R.id.loveFragment2
            )
        )
    }

}