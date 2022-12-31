package com.example.lovestory.fragmenlove1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovestory.App
import com.example.lovestory.R
import com.example.lovestory.databinding.FragmentLove1Binding
import com.example.lovestory.history.HistoryViewModel
import com.example.lovestory.main.LoveViewModel
import com.example.lovestory.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveFragment1 : Fragment() {
    private lateinit var binding: FragmentLove1Binding
    private val viewModel: LoveViewModel by viewModels()
    private val historyViewModel: HistoryViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLove1Binding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {

        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstName.text.toString(),
                    secondName.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {  historyViewModel.getInsert(it)

                        findNavController().navigate(
                            R.id.loveFragment2, bundleOf("key" to it)

                        )
                    })
            }
            historyBtn.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }

        }
    }
}