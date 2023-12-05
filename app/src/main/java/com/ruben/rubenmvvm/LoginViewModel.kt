package com.ruben.rubenmvvm

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var enteredUsername: String = ""
    var enteredPassword: String = ""
    var currentUser: User? = null

    fun isLoginValid(): Boolean {
        currentUser = getUserFromTable(enteredUsername)
        return currentUser != null && currentUser!!.password == enteredPassword
    }

    private fun getUserFromTable(username: String): User? {
        val users = listOf(
            User("ruben", "123"),
            User("enaitz", "321"),
            User("messi", "111"),
            User("ronaldo", "222"),
            User("alonso", "333")
        )

        return users.find { it.username == username }
    }
}



