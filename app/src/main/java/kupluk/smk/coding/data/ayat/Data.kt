package kupluk.smk.coding.data.ayat


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ar")
    val ar: List<Ar>,
    @SerializedName("id")
    val id: List<Id>,
    @SerializedName("idt")
    val idt: List<Idt>
)