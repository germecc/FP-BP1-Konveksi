package model

class ProdukCustom(
    id: Int,
    nama: String,
    harga: Int,
    val bahan: String
) : Produk(id, nama, harga) {
    override fun infoProduk(): String {
        return "$nama (Custom, Bahan: $bahan) - Rp$harga"
    }
}
