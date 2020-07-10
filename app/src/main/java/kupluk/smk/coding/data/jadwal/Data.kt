package kupluk.smk.coding.data.jadwal


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ashar")
    val ashar: String,
    @SerializedName("dhuha")
    val dhuha: String,
    @SerializedName("dzuhur")
    val dzuhur: String,
    @SerializedName("imsak")
    val imsak: String,
    @SerializedName("isya")
    val isya: String,
    @SerializedName("maghrib")
    val maghrib: String,
    @SerializedName("subuh")
    val subuh: String,
    @SerializedName("tanggal")
    val tanggal: String,
    @SerializedName("terbit")
    val terbit: String
)