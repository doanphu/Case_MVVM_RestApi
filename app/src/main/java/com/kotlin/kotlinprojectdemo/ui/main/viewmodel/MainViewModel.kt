package com.kotlin.kotlinprojectdemo.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kotlin.kotlinprojectdemo.data.repository.Repository
import com.kotlin.kotlinprojectdemo.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: Repository) : ViewModel() {
    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

//    fun getResultSearch(keyWork: String) = liveData(Dispatchers.IO) {
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = mainRepository.getResultSearch(keyWork)))
//        } catch (exception: Exception) {
//            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
//        }
//    }
}