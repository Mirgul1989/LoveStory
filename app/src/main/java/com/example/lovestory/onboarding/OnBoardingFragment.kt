package com.example.lovestory.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovestory.R
import com.example.lovestory.adapter.OnBoardingAdapter
import com.example.lovestory.data.Pref
import com.example.lovestory.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter

    @Inject
    lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter {
            pref.saveShowOnBoarding(true)
            findNavController().navigateUp()
        }

        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }

}
