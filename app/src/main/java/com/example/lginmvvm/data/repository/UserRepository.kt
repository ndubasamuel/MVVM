package com.example.lginmvvm.data.repository


import androidx.lifecycle.MutableLiveData
import com.example.lginmvvm.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response


class UserRepository {

    fun userLogin(email: String, password: String): MutableLiveData<String> {

        val loginResponse = MutableLiveData<String>()

        MyApi().userLogin(email, password)
            .enqueue(object: retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        loginResponse.value = response.body()?.string()
                    } else {
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })
        return loginResponse
    }


}


