package com.ruben.rubenmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {
    private val _selectedUser = MutableLiveData<User?>()
    val currentUser: LiveData<User?> get() = _selectedUser

    private val _userDetailLiveData = MutableLiveData<UserDetail>()
    val userDetailLiveData: LiveData<UserDetail> get() = _userDetailLiveData

    private val users = listOf(
        User("ruben", "20"),
        User("enaitz", "28"),
        User("messi", "10"),
        User("ronaldo", "54"),
        User("alonso", "47")
    )

    private var currentIndex = 0

    fun getNextUserDetail(): User {
        val user = users[currentIndex]
        currentIndex = (currentIndex + 1) % users.size
        val userDetail = UserDetail(user.username, user.password)
        _userDetailLiveData.value = userDetail
        return user
    }

    fun updateCurrentUser(user: User?) {
        _selectedUser.value = user
    }
}





