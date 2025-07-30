package model

data class Pesanan(
    val id: Int,
    val user: User,
    val produk: Produk,
    val jumlah: Int,
    val ukuran: String
) {
    fun totalHarga(): Int {
        return produk.harga * jumlah
    }
}
