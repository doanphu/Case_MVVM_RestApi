package com.kotlin.kotlinprojectdemo.data.network

import com.kotlin.kotlinprojectdemo.data.model.User
import com.kotlin.spweather_app.model.ResulSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("search.ashx?format=json&key=6fe0e24c40354453beb152141202702")
    suspend fun getResultSearch(@Query("query") query: String): Response<ResulSearch>
}