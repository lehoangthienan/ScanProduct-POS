package com.vision.block.kotlin.view.scanproduct

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.util.SparseArray
import android.widget.Toast
import com.google.android.gms.vision.barcode.Barcode
import com.vision.block.kotlin.R
import com.vision.block.kotlin.view.productdetail.ProductDetailActivity
import info.androidhive.barcode.BarcodeReader


class ScanProductActivity : AppCompatActivity(), BarcodeReader.BarcodeReaderListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_product)

        initView()
    }

    private fun initView() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>?) {
        if (sparseArray != null) {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("id", sparseArray[0].displayValue)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }

    override fun onScannedMultiple(barcodes: MutableList<Barcode>?) {

    }

    override fun onScanned(barcode: Barcode?) {

    }

    override fun onScanError(errorMessage: String?) {
        Toast.makeText(this@ScanProductActivity, "Error occurred while scanning", Toast.LENGTH_SHORT).show();
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
