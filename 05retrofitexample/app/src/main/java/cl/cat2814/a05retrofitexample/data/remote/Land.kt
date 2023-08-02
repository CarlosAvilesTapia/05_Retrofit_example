package cl.cat2814.a05retrofitexample.data.remote

import com.google.gson.annotations.SerializedName

data class Land(
    val id: String,
    val price: Int,
    val type: String,
    @SerializedName("img_src") val imgUrl: String
)
