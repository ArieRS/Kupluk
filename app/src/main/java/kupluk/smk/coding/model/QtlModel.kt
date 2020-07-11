package kupluk.smk.coding.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_friend")
data class QtlModel(
    var surat: String,
    var ayat: String,
    var halaman: String,
    var tanggal: String,
    @PrimaryKey var key: String
){
    constructor() : this("","","","",""
    )
}