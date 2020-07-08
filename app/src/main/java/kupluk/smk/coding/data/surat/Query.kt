package kupluk.smk.coding.data.surat


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("format")
    val format: String,
    @SerializedName("surat")
    val surat: String
)