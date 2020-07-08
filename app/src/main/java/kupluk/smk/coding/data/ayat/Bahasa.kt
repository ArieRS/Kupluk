package kupluk.smk.coding.data.ayat


import com.google.gson.annotations.SerializedName

data class Bahasa(
    @SerializedName("keterangan")
    val keterangan: List<String>,
    @SerializedName("proses")
    val proses: List<String>
)