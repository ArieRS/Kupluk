package kupluk.smk.coding.data.jadwal


import com.google.gson.annotations.SerializedName

data class JadwalX(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)