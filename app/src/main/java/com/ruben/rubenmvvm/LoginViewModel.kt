package com.ruben.rubenmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _currentUser = MutableLiveData<User?>()
    val currentUser: LiveData<User?> get() = _currentUser

    var enteredUsername: String = ""
    var enteredPassword: String = ""

    fun isLoginValid() {
        val user = getUserFromTable(enteredUsername)
        if (user != null && user.password == enteredPassword) {
            _currentUser.value = user
        } else {
            _currentUser.value = null
        }
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



