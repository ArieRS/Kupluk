package kupluk.smk.coding.data

data class News(
    var title: String,
    var description: String,
    var image: String,
    var key: String
) {
    constructor() : this("","","", "")
}