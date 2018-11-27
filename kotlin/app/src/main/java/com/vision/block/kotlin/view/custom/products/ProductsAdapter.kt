package com.vision.block.kotlin.view.custom.products

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vision.block.kotlin.R
import com.vision.block.kotlin.data.response.Product

class ProductsAdapter(
    private var products: ArrayList<Product>,
    private var onItemClickedListener: OnItemClickedListener
) : RecyclerView.Adapter<ProductsViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        context = parent.context
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindData(
            context,
            products[products.size - position - 1],
            onItemClickedListener
        )
    }

    interface OnItemClickedListener {
        fun onItemClicked(id: String)
    }
}
