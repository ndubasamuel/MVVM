package com.example.lginmvvm.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onFailure(message: String)
    fun onSuccess(loginResponse: LiveData<String>)
    fun onSuccess(loginResponse: Any) {
        TODO("Not yet implemented")
    }
}