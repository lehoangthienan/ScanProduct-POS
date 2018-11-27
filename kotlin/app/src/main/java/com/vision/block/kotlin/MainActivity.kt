package com.vision.block.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.ActionBar
import android.util.Log
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.vision.block.kotlin.view.showproducts.ShowProductsActivity
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setTimeSleep()
    }

    @SuppressLint("CheckResult")
    private fun setTimeSleep() {
        val handler = Handler()
        handler.postDelayed({
            startSalesManagerActivity()
        }, 2000)
    }

    private fun startSalesManagerActivity() {
        val intent = Intent(this, ShowProductsActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initView() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }
}
