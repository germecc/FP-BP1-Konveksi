package controller

import model.*

class KonveksiController {
    private val produkList = mutableListOf<Produk>()
    private val pesananList = mutableListOf<Pesanan>()
    private var nextPesananId = 1

    init {
        produkList.add(Produk(1, "Kaos", 50000))
        produkList.add(Produk(2, "Jaket", 150000))
        produkList.add(ProdukCustom(3, "Hoodie Custom", 200000, "Fleece"))
    }

    fun tampilkanProduk() {
        println("\n== Daftar Produk ==")
        produkList.forEach {
            println("${it.id}. ${it.infoProduk()}")
        }
    }

    fun buatPesanan(user: User) {
        tampilkanProduk()
        print("Pilih ID Produk: ")
        val id = readLine()?.toIntOrNull() ?: return
        val produk = produkList.find { it.id == id } ?: run {
            println("Produk tidak ditemukan.")
            return
        }

        print("Jumlah: ")
        val jumlah = readLine()?.toIntOrNull() ?: return

        print("Ukuran (S/M/L/XL): ")
        val ukuran = readLine().orEmpty()

        val pesanan = Pesanan(nextPesananId++, user, produk, jumlah, ukuran)
        pesananList.add(pesanan)
        println("Pesanan berhasil dibuat.")
    }

    fun tampilkanPesananUser(user: User) {
        println("\n== Daftar Pesanan Anda ==")
        val pesananUser = pesananList.filter { it.user == user }
        if (pesananUser.isEmpty()) {
            println("Belum ada pesanan.")
        } else {
            pesananUser.forEach {
                println("[${it.id}] ${it.produk.nama} x${it.jumlah} (Uk: ${it.ukuran}) - Total: Rp${it.totalHarga()}")
            }
        }
    }

    fun hapusPesanan(user: User) {
        tampilkanPesananUser(user)
        print("Masukkan ID pesanan yang ingin dihapus: ")
        val id = readLine()?.toIntOrNull() ?: return
        val success = pesananList.removeIf { it.id == id && it.user == user }
        if (success) {
            println("Pesanan berhasil dihapus.")
        } else {
            println("Gagal menghapus pesanan. Mungkin ID salah.")
        }
    }
}
