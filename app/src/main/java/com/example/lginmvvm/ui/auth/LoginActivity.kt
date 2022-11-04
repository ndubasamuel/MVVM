package com.example.lginmvvm.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.lginmvvm.R
import com.example.lginmvvm.databinding.ActivityLoginBinding
import com.example.lginmvvm.utis.hide
import com.example.lginmvvm.utis.show
import com.example.lginmvvm.utis.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView( this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()

    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this) {
            progress_bar.hide()
            toast(it)
        }


    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)

    }
}