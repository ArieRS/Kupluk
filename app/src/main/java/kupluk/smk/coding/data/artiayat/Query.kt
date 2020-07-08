package kupluk.smk.coding.data.artiayat


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("ayat")
    val ayat: String,
    @SerializedName("ayat2")
    val ayat2: List<Int>,
    @SerializedName("bahasa")
    val bahasa: String,
    @SerializedName("bahasa2")
    val bahasa2: List<String>,
    @SerializedName("format")
    val format: String,
    @SerializedName("surat")
    val surat: String
)