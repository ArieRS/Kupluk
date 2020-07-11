package kupluk.smk.coding.data.jadwal


import com.google.gson.annotations.SerializedName

data class jadwal(
    @SerializedName("jadwal")
    val jadwal: JadwalX,
    @SerializedName("query")
    val query: Query,
    @SerializedName("status")
    val status: String
)