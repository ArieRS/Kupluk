package kupluk.smk.coding.data.artiayat


import com.google.gson.annotations.SerializedName

data class Ayat(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("error")
    val error: List<Int>,
    @SerializedName("proses")
    val proses: List<Int>
)