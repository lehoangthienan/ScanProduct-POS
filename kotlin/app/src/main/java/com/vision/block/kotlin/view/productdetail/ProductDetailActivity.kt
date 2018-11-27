package com.vision.block.kotlin.view.productdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ScrollView
import com.bumptech.glide.Glide
import com.vision.block.kotlin.R
import com.vision.block.kotlin.data.response.Log
import com.vision.block.kotlin.data.response.Product
import com.vision.block.kotlin.utils.ProductManagerUtils
import com.vision.block.kotlin.view.custom.logs.LogAdapter
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    private var productId: String = ""
    private var products = ArrayList<Product>()
    private var logs = ArrayList<Log>()
    private lateinit var productManagerUtils: ProductManagerUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        productManagerUtils = ProductManagerUtils.getInstance(this@ProductDetailActivity)
        initView()
        getProductId()
        getProductDetail()
        addEvents()
    }

    @SuppressLint("CheckResult")
    private fun getProductDetail() {
        if (productManagerUtils.getProducts() != null) {
            products = productManagerUtils.getProducts()
        }
        products.map { product ->
            if (product != null) {
                if (product.logs != null) {
                    logs = product.logs!!
                    showLogs(logs)
                }
                if (product.id == productId) initProductData(product)
            }
        }
    }

    private fun showLogs(logs: ArrayList<Log>) {
        try {
            rvLogs.apply {
                this.layoutManager = LinearLayoutManager(this@ProductDetailActivity)
                this.adapter = LogAdapter(logs)
            }
        } catch (e: Exception) {
        }
    }

    private fun addEvents() {
        tvBack.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    private fun initProductData(product: Product) {

        tvProductName.text = product.name
        try {
            ivProduct?.let {
                Glide.with(this)
                    .asBitmap()
                    .load(product.image)
                    .into(it)
            }
        } catch (e: Exception) {
        }
        tvBranchName.text = product.owner
        tvContent.text = product.content
    }

    private fun getProductId() {
        productId = intent?.getStringExtra("ID") ?: ""
    }

    private fun initView() {
        svPD.fullScroll(ScrollView.FOCUS_UP)
        rvLogs.isFocusable = false
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

    }
}
