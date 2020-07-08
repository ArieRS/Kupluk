package kupluk.smk.coding.data.surat


import com.google.gson.annotations.SerializedName

data class Surat(
    @SerializedName("hasil")
    val hasil: List<Hasil>,
    @SerializedName("query")
    val query: Query,
    @SerializedName("status")
    val status: String
)