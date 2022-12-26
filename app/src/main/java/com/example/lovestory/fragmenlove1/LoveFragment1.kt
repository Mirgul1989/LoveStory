package com.example.lovestory.fragmenlove1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovestory.R
import com.example.lovestory.databinding.FragmentLove1Binding
import com.example.lovestory.model.LoveModel
import com.example.lovestory.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoveFragment1 : Fragment() {
    private lateinit var binding: FragmentLove1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLove1Binding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
                RetrofitService().getLoveApi().getResult(
                    firstName = firstNameEd.text.toString(),
                    secondName = secondNameEd.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", "onResponse: ${response.body()?.percentage}")
                        val bundle = bundleOf(
                            "fname" to firstNameEd.text.toString(),
                            "sname" to secondNameEd.text.toString(),
                            "percentage" to response.body()?.percentage

                        )
                        findNavController().navigate(R.id.action_loveFragment1_to_loveFragment2,bundle)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message} ")
                    }

                })
    }
}}}