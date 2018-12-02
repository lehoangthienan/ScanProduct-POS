package com.vision.block.kotlin.view.custom.logs

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.vision.block.kotlin.data.response.Log
import kotlinx.android.synthetic.main.item_logs.view.*

class LogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(
        log: Log
    ) {
        loadText(log, itemView)
    }

    @SuppressLint("SetTextI18n")
    private fun loadText(log: Log, itemView: View) {
        itemView.tvDate.text = "Time: " + log.date.toString()
        itemView.tvContent.text = "Content: " + log.content
        itemView.tvPartner.text = "Partner: " + log.partner
    }

}