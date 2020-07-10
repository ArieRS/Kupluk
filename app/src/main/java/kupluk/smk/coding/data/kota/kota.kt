package kupluk.smk.coding.data.kota


import com.google.gson.annotations.SerializedName

data class kota(
    @SerializedName("kota")
    val kota: List<KotaX>,
    @SerializedName("query")
    val query: Query,
    @SerializedName("status")
    val status: String
)