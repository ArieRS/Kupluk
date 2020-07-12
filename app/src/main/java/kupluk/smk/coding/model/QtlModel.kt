package kupluk.smk.coding.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qtl_kupluk")
data class QtlModel(
    var surat: String,
    var ayat: String,
    var halaman: String,
    var waktu: String,
    @PrimaryKey var key: String
){
    constructor() : this("","","","",""
    )
}