package com.vision.block.kotlin.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Product(

    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null,

    @SerializedName("owner")
    @Expose
    var owner: String? = null,

    @SerializedName("content")
    @Expose
    var content: String? = null,

    @SerializedName("logs")
    @Expose
    var logs: ArrayList<Log>? = null

) {
    companion object {
        fun createBlankAddressLocation(): Product {
            return Product("", "", "", "", "")
        }
    }
}

data class Log(
    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("date")
    @Expose
    var date: Date,

    @SerializedName("content")
    @Expose
    var content: String? = null
)