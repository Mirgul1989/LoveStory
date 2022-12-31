package com.example.lovestory.history.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovestory.R
import com.example.lovestory.databinding.ItemHistoryBinding
import com.example.lovestory.remote.LoveModel

class HistoryAdapter(private val list: ArrayList<LoveModel> = arrayListOf(), val context: Context) :
    Adapter<HistoryAdapter.HistoryViewHoder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHoder {
        return HistoryViewHoder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHoder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addHistory(modelHistory: List<LoveModel>) {
        this.list.clear()
        this.list.addAll(modelHistory)
        notifyDataSetChanged()


    }

    inner class HistoryViewHoder(private val binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun bind(list: LoveModel) {
            with(binding)
            {
                tvFirsName.text=list.firstName
                tvSecondName.text = list.secondName
                percentage1.text = list.percentage
                result1.text = list.result
            }

            itemView.setOnLongClickListener {
                onLong(list)
                return@setOnLongClickListener true
            }
        }

        private fun onLong(loveModel: LoveModel) {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Update?")
            alertDialog.setNegativeButton("Cansel", DialogInterface.OnClickListener { _, _ ->
            })
            alertDialog.setNegativeButton("Cansel", DialogInterface.OnClickListener { _, _ -> })
            alertDialog.show()

        }
    }
}