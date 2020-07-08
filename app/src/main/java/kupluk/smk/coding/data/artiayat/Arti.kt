package kupluk.smk.coding.data.artiayat


import com.google.gson.annotations.SerializedName
import retrofit2.Call

data class Arti(
    @SerializedName("ayat")
    val ayat: Ayat,
    @SerializedName("bahasa")
    val bahasa: Bahasa,
    @SerializedName("query")
    val query: Query,
    @SerializedName("status")
    val status: String,
    @SerializedName("surat")
    val surat: Surat
)