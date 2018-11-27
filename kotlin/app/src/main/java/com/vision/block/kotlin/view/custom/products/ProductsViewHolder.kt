package com.vision.block.kotlin.view.custom.products

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.vision.block.kotlin.data.response.Product
import kotlinx.android.synthetic.main.item_products.view.*

class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(
        context: Context,
        product: Product,
        onItemClickedListener: ProductsAdapter.OnItemClickedListener
    ) {
        loadImage(context, product, itemView)
        loadText(product, itemView)
        addEvents(itemView, onItemClickedListener, product)
    }

    private fun addEvents(
        itemView: View,
        onItemClickedListener: ProductsAdapter.OnItemClickedListener,
        product: Product
    ) {
        itemView.cvItemProduct.setOnClickListener {
            onItemClickedListener.onItemClicked(product.id.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadText(product: Product, itemView: View) {
        itemView.tvName.text = product.name
        itemView.tvBranchName.text = product.owner
    }

    private fun loadImage(context: Context, product: Product, itemView: View?) {
        itemView?.ivProduct?.let {
            Glide.with(context)
                .asBitmap()
                .load(product.image)
                .into(it)
        }
    }
}