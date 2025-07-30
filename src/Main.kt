import controller.AuthController
import controller.KonveksiController
import view.MenuView

fun main() {
    val auth = AuthController()
    val konveksi = KonveksiController()

    var currentUser: model.User? = null

    while (currentUser == null) {
        println("\n=== APLIKASI KONVEKSI ===")
        println("1. Login")
        println("2. Register")
        println("0. Logout")
        print("Pilih: ")
        when (readLine()) {
            "1" -> currentUser = auth.login()
            "2" -> auth.register()
            "0" -> return
            else -> println("Pilihan tidak valid")
        }
    }

    // Menu Utama (Perulangan)
    while (true) {
        MenuView.tampilkanMenu()
        when (readLine()) {
            "1" -> konveksi.tampilkanProduk()
            "2" -> konveksi.buatPesanan(currentUser)
            "3" -> konveksi.tampilkanPesananUser(currentUser)
            "4" -> konveksi.hapusPesanan(currentUser)
            "0" -> {
                println("Logout berhasil. Sampai jumpa, ${currentUser.username}!")
                break
            }
            else -> println("Pilihan tidak valid")
        }
    }
}