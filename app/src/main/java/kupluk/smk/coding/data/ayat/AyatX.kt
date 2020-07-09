package kupluk.smk.coding.data.ayat


import com.google.gson.annotations.SerializedName

data class AyatX(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("proses")
    val proses: List<Int>
)