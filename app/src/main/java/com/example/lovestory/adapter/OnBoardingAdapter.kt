package com.example.lovestory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovestory.data.OnBoard
import com.example.lovestory.R
import com.example.lovestory.databinding.ItemOnBoardingBinding

class OnBoardingAdapter(val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val arrayList = arrayListOf<OnBoard>(
        OnBoard(
            R.raw.ic_love1,
            "Что такое калькулятор любви? ",
            "Когда вы находите новых людей, вы, должно быть, думаете о том, какими будут ваши потенциальные отношения с вашим партнером в будущем. "
        ),
        OnBoard(
            R.raw.ic_love4,
            " Вычислить любовь по имени! ",
            "Вы можете использовать наш бесплатный онлайн-тест на любовь, чтобы подсчитать счет между вами и вашим возможным партнером."
        ),
        OnBoard(
            R.raw.ic_love3,
            "Что такое любовь?",
            "Глубокая привязанность начинается с хороших привычек и заканчивается глубочайшей межличностной привязанностью."
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )

    }


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onClick()
            }
            onBoard.image?.let { binding.animationView1.setAnimation(it) }
            binding.title.text = onBoard.title
            binding.description.text = onBoard.desc

        }
    }
}