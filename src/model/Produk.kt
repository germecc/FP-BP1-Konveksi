package model

open class Produk(
    val id: Int,
    val nama: String,
    val harga: Int
) {
    open fun infoProduk(): String {
        return "$nama - Rp$harga"
    }
}
