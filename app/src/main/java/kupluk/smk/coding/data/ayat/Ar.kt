package kupluk.smk.coding.data.ayat


import com.google.gson.annotations.SerializedName

data class Ar(
    @SerializedName("ayat")
    val ayat: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("surat")
    val surat: String,
    @SerializedName("teks")
    val teks: String
)