package com.ruben.rubenmvvm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel(){
    val _user = MutableLiveData<User>()

    fun login(name: String, password: String) {
        _user.value = User(name, password)
    }

}