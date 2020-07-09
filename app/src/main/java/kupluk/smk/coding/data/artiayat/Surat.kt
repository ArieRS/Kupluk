package kupluk.smk.coding.data.artiayat


import com.google.gson.annotations.SerializedName

data class Surat(
    @SerializedName("arti")
    val arti: String,
    @SerializedName("asma")
    val asma: String,
    @SerializedName("ayat")
    val ayat: String,
    @SerializedName("keterangan")
    val keterangan: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nomor")
    val nomor: String,
    @SerializedName("rukuk")
    val rukuk: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("urut")
    val urut: String
)