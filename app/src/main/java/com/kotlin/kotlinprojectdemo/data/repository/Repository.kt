package com.kotlin.kotlinprojectdemo.data.repository

import com.kotlin.kotlinprojectdemo.data.network.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUser()
//    suspend fun getResultSearch(keyWork: String) = apiHelper.getResultSearch(keyWork)
}