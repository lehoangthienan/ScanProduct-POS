package com.vision.block.kotlin.view.scanproduct

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import com.vision.block.kotlin.R
import kotlinx.android.synthetic.main.activity_intro_scan.*

class IntroScanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_scan)

        initView()
        addeEvents()
    }

    private fun addeEvents() {
        btScan.setOnClickListener {
            val intent = Intent(this, ScanProductActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    private fun initView() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }
}
