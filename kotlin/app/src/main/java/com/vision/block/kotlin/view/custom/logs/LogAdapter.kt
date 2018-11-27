package com.vision.block.kotlin.view.custom.logs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vision.block.kotlin.R
import com.vision.block.kotlin.data.response.Log

class LogAdapter (
    private var logs: ArrayList<Log>
) : RecyclerView.Adapter<LogViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logs, parent, false)
        context = parent.context
        return LogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        holder.bindData(
            logs[logs.size - position - 1]
        )
    }
}
