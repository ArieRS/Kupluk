package kupluk.smk.coding.data.jadwal


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("format")
    val format: String,
    @SerializedName("kota")
    val kota: String,
    @SerializedName("tanggal")
    val tanggal: String
)