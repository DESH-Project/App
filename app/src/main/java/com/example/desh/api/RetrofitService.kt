package com.example.desh.api

import com.example.desh.dto.PredictDto
import com.example.desh.dto.UserDto
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {
    @POST("login")
    fun login(@Query("userLoginReq") userLoginReq: UserDto.UserLoginReq) : Call<UserDto.UserLoginRes>

    @POST("signup")
    fun signup(@Query("userSignUpReq") userSignUpReq: UserDto.UserSignUpReq) : Call<Long>

    @POST("predict")
    fun predict(@Query("predictReq") predictReq: PredictDto.PredictReq) : Call<Long>   // Todo

    companion object {
        private const val BASE_URL = "http://localhost:8080/"
        private val gson = GsonBuilder().setLenient().create()

        fun create() : RetrofitService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetrofitService::class.java)
        }
    }
}