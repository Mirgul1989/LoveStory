package com.example.lovestory.fragmentlove2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovestory.R
import com.example.lovestory.databinding.FragmentLove2Binding
import com.example.lovestory.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveFragment2 : Fragment() {
    private lateinit var binding: FragmentLove2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLove2Binding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: LoveModel = arguments?.getSerializable("key") as LoveModel
        binding.tvMe.text = data.firstName
        binding.tvYou.text = data.secondName
        binding.tvResult.text = data.result
        binding.tvPercentage.text = data.percentage

    }
}



