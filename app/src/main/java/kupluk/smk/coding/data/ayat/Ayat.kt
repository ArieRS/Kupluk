package kupluk.smk.coding.data.ayat


import com.google.gson.annotations.SerializedName

data class Ayat(
    @SerializedName("ayat")
    val ayat: AyatX,
    @SerializedName("bahasa")
    val bahasa: Bahasa,
    @SerializedName("query")
    val query: Query,
    @SerializedName("status")
    val status: String,
    @SerializedName("surat")
    val surat: Surat
)