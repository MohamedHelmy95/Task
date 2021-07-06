package com.promoclicks.data.response

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs


data class HomeResponse(
    @SerializedName("data")
    val `data`: HomeResponseData?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
)

data class HomeResponseData(
    @SerializedName("hot_product_paid_status")
    val hotProductPaidStatus: List<HotProductPaidStatu>?,
    @SerializedName("hot_saller_paid_status")
    val hotSallerPaidStatus: List<HotSallerPaidStatu>?,
    @SerializedName("recommend_paid_status")
    val recommendPaidStatus: List<RecommendPaidStatu>?,
    @SerializedName("Sliders")
    val sliders: List<Slider>?,
    @SerializedName("Sponsors")
    val sponsors: List<Sponsor>?,
    @SerializedName("vendor")
    val vendor: List<Vendor>?
)

data class HotProductPaidStatu(
    @SerializedName("exp_date")
    val expDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("new_price")
    val newPrice: Int?,
    @SerializedName("old_price")
    val oldPrice: Int?,
    @SerializedName("ProductUserNumber")
    val productUserNumber: Int?,
    @SerializedName("rate")
    val rate: Double?,
    var isSelected: Boolean = false
) {
    fun getOldPriceString() = oldPrice.toString()
    fun getNewPriceString() = newPrice.toString()
    fun getDays(): String {
        val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH)
        val date = sdf.parse(expDate ?: "")
        val current = Calendar.getInstance().timeInMillis
        val diff: Long = abs(current - date.time)
        return if (diff == 0L) "Expired" else """End in  ${
            TimeUnit.DAYS.convert(
                diff,
                TimeUnit.MILLISECONDS
            )
        }   Days"""
    }

    fun getFloatRate() = rate?.toFloat()
    fun getRatings() = "($productUserNumber ratings )"


}

data class HotSallerPaidStatu(
    @SerializedName("exp_date")
    val expDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("new_price")
    val newPrice: Int?,
    @SerializedName("old_price")
    val oldPrice: Int?,
    @SerializedName("ProductUserNumber")
    val productUserNumber: Int?,
    @SerializedName("rate")
    val rate: Double?
)

data class RecommendPaidStatu(
    @SerializedName("exp_date")
    val expDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("new_price")
    val newPrice: Int?,
    @SerializedName("old_price")
    val oldPrice: Int?,
    @SerializedName("ProductUserNumber")
    val productUserNumber: Int?,
    @SerializedName("rate")
    val rate: Double?
)

data class Slider(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("product")
    val product: Int?,
    @SerializedName("title")
    val title: String?
)

data class Sponsor(
    @SerializedName("image")
    val image: String?
)

data class Vendor(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sub_id")
    val subId: String?
)