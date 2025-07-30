package controller

import model.User

class AuthController {
    private val userList = mutableListOf<User>()

    fun register() {
        println("--- Registrasi ---")
        print("Username: ")
        val username = readLine().orEmpty()
        print("Password: ")
        val password = readLine().orEmpty()

        if (userList.any { it.username == username }) {
            println("Username sudah digunakan.")
        } else {
            userList.add(User(username, password))
            println("Registrasi berhasil!")
        }
    }

    fun login(): User? {
        println("--- Login ---")
        print("Username: ")
        val username = readLine().orEmpty()
        print("Password: ")
        val password = readLine().orEmpty()

        val user = userList.find { it.username == username && it.password == password }
        return if (user != null) {
            println("Login berhasil! Selamat datang, ${user.username}")
            user
        } else {
            println("Login gagal.")
            null
        }
    }
}
