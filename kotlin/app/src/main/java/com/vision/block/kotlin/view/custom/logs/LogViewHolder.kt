package com.vision.block.kotlin.view.custom.logs

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.vision.block.kotlin.data.response.Log
import com.vision.block.kotlin.data.response.Product
import kotlinx.android.synthetic.main.item_logs.view.*

class LogViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(
        log: Log
    ) {
        loadText(log, itemView)
    }

    @SuppressLint("SetTextI18n")
    private fun loadText(log: Log, itemView: View) {
        itemView.tvDate.text = log.date.toString()
        itemView.tvContent.text = log.content
    }

}