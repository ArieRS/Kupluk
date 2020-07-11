package kupluk.smk.coding.data.kota


import com.google.gson.annotations.SerializedName

data class KotaX(
    @SerializedName("id")
    val id: String,
    @SerializedName("nama")
    val nama: String
)