package com.example.myapplication.service

import com.example.myapplication.CreateOrderResponse
import com.example.myapplication.SignInRequest
import com.example.myapplication.SignInResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface CleanAceService {

    @POST("/read.php")
    fun signIn(@Body signInRequest: SignInRequest) : Call<SignInResponse>
    @POST("/insert.php")
    fun createOrder(): Call<CreateOrderResponse>

    companion object{
        val instance: CleanAceService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://intellifarms.com.ng/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create<CleanAceService>(CleanAceService::class.java)
        }
    }
}