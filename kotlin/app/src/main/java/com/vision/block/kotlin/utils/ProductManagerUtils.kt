package com.vision.block.kotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vision.block.kotlin.data.response.Product

class ProductManagerUtils constructor(var context: Context) {

    companion object : ArgumentSingletonHolder<ProductManagerUtils, Context>(::ProductManagerUtils)

    var sharedPrefsExtraUserInformation: SharedPreferences =
        context.getSharedPreferences(Constant.EXTRA_USER_INFORMATION, Context.MODE_PRIVATE)

    fun fillerProductsForKey(products: ArrayList<Product>, key: String): ArrayList<Product> {
        val productsForKey = ArrayList<Product>()
        if (products.isNotEmpty() && products != null) {
            products.forEach { product ->
                if (product.name!!.toLowerCase().contains(key.toLowerCase())) productsForKey.add(product)
            }
        }
        return productsForKey
    }

    fun setProducts(productList: ArrayList<Product>) {
        if (productList.isEmpty()) productList.add(Product.createBlankAddressLocation())
        val editor = sharedPrefsExtraUserInformation.edit()
        val gson = Gson()
        val json = gson.toJson(productList)
        editor.putString("Products", json)
        editor.apply()
    }

    fun getProducts(): ArrayList<Product> {
        val gson = Gson()
        val json = sharedPrefsExtraUserInformation.getString("Products", setProductsDefault())
        val type = object : TypeToken<ArrayList<Product>>() {}.type
        return gson.fromJson(json, type)
    }

    fun setProductsDefault(): String? {
        val addressLocationDefault = ArrayList<Product>()
        addressLocationDefault.add(Product.createBlankAddressLocation())
        val gsonDefault = Gson()
        return gsonDefault.toJson(addressLocationDefault)
    }
}