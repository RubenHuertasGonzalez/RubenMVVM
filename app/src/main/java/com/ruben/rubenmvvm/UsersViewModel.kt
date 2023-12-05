package com.ruben.rubenmvvm

import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {
    private var _selectedUser: User? = null
        set(value) {
            field = value
        }

    var currentUser: User?
        get() = _selectedUser
        set(value) {
            _selectedUser = value
        }

    private val userDetailTable = listOf(
        UserDetail("ruben", "20", "ruben@gmail.com"),
        UserDetail("enaitz", "28", "enaitz@gmail.com"),
        UserDetail("messi", "10", "messi@gmail.com"),
        UserDetail("ronaldo", "54", "ronaldo@gmail.com"),
        UserDetail("alonso", "47", "alonso@gmail.com")
    )

    private var currentIndex = 0

    fun getNextUserDetail(): UserDetail {
        val userDetail = userDetailTable[currentIndex]
        currentIndex = (currentIndex + 1) % userDetailTable.size
        return userDetail
    }

    fun updateCurrentUser(user: User?) {
        _selectedUser = user
    }

    fun getSpecificUserDetail(): UserDetail? {
        return userDetailTable.find {
            it.username == _selectedUser?.username
        }
    }
}
