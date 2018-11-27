package com.vision.block.kotlin.view.showproducts

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.RxTextView
import com.vision.block.kotlin.R
import com.vision.block.kotlin.data.response.Log
import com.vision.block.kotlin.data.response.Product
import com.vision.block.kotlin.utils.ProductManagerUtils
import com.vision.block.kotlin.utils.getVisibilityView
import com.vision.block.kotlin.view.custom.products.ProductsAdapter
import com.vision.block.kotlin.view.productdetail.ProductDetailActivity
import com.vision.block.kotlin.view.scanproduct.IntroScanActivity
import com.vision.block.kotlin.view.scanproduct.ScanProductActivity
import kotlinx.android.synthetic.main.activity_show_products.*
import java.util.*


class ShowProductsActivity : AppCompatActivity() {

    private var products = ArrayList<Product>()
    private var logs = ArrayList<Log>()
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var productManagerUtils: ProductManagerUtils
    var currentTime = Calendar.getInstance().time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_products)

        productManagerUtils = ProductManagerUtils.getInstance(this@ShowProductsActivity)
        fakeData()
        initView()
        showProducts()
        addEvents()
    }

    @SuppressLint("CheckResult")
    private fun addEvents() {
        swipeContainer.setOnRefreshListener {
            showProducts()
        }
        RxTextView.textChanges(etSearch).subscribe { key ->
            if (key.isNullOrBlank()) showProducts()
            else {
                productsAdapter = ProductsAdapter(
                    productManagerUtils.fillerProductsForKey(products, key.toString()),
                    object : ProductsAdapter.OnItemClickedListener {
                        override fun onItemClicked(id: String) {
                            startProductDetailActivity(id)
                        }
                    })
                setProductsView()
            }
        }
        fabScan.setOnClickListener {
            startScanActivity()
        }
    }

    private fun startScanActivity() {
        val intent = Intent(this, IntroScanActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun initView() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

    }

    @SuppressLint("CheckResult")
    private fun showProducts() {
        productsAdapter = ProductsAdapter(products, object : ProductsAdapter.OnItemClickedListener {
            override fun onItemClicked(id: String) {
                startProductDetailActivity(id)
            }
        })
        setProductsView()
    }

    private fun startProductDetailActivity(id: String) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun setProductsView() {
        try {
            rvProducts.apply {
                this.layoutManager = LinearLayoutManager(this@ShowProductsActivity)
                this.adapter = productsAdapter
            }
            progressBarAddLocation.visibility = getVisibilityView(false)
            swipeContainer.isRefreshing = false
        } catch (e: Exception) {
        }
    }

    private fun fakeData() {
        logs.add(Log("1",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("2",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("3",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("4",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("5",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("1",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("2",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("3",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("4",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("5",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("1",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("2",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("3",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("4",currentTime,"Under the draft agreement, the UK will stay inside"))
        logs.add(Log("5",currentTime,"Under the draft agreement, the UK will stay inside"))
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        products.add(
            Product(
                "1",
                "Banana",
                "https://tul.imgix.net/content/article/banana.jpg?auto=format,compress&w=740&h=486&fit=crop&crop=edges",
                "Daniel Le",
                "Under the draft agreement, the UK will stay inside the bloc's single market and remain subject to EU laws and regulations until the end of December 2020 while the two sides attempt to iron out a new trade relationship.\n" +
                        "During this period, all existing EU \"regulatory, budgetary, supervisory, judiciary and enforcement instruments and structures\" will continue to apply within the UK, including rulings made in the Court of Justice of the EU.",
                logs
            )
        )
        productManagerUtils.setProducts(products)
    }
}
