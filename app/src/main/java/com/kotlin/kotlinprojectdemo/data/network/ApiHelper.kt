package com.kotlin.kotlinprojectdemo.data.network

class ApiHelper(private val apiInterface: ApiInterface) {
    suspend fun getUser() = apiInterface.getUsers()

//    suspend fun getResultSearch(keyWork: String) = apiInterface.getResultSearch(keyWork)
}