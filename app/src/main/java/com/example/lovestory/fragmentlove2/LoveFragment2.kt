package com.example.lovestory.fragmentlove2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovestory.R
import com.example.lovestory.databinding.FragmentLove2Binding


class LoveFragment2 : Fragment() {
    private lateinit var binding: FragmentLove2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLove2Binding.inflate(layoutInflater)
        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.tvMe.text=arguments?.getString("fname")
            binding.tvYou.text=arguments?.getString("sname")
            binding.outlinedTv.text=arguments?.getString("percentage")


        }
    }



