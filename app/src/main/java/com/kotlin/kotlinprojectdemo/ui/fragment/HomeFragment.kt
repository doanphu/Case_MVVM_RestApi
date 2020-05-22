package com.kotlin.kotlinprojectdemo.ui.fragment

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.kotlin.kotlinprojectdemo.R
import com.kotlin.kotlinprojectdemo.data.network.ApiBuilder
import com.kotlin.kotlinprojectdemo.data.network.ApiHelper
import com.kotlin.kotlinprojectdemo.ui.base.BaseFragment
import com.kotlin.kotlinprojectdemo.ui.base.ViewModelFactory
import com.kotlin.kotlinprojectdemo.ui.main.viewmodel.MainViewModel
import com.kotlin.kotlinprojectdemo.utils.Status

class HomeFragment() : BaseFragment() {
    private val TAG: String = "HomeFragment"
    private lateinit var mainViewModel: MainViewModel

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun getRootLayoutId(): Int {
        Log.d(TAG, "getRootLayoutId")
        return R.layout.fragment_home2
    }

    override fun setUpViewModel() {
        Log.d(TAG, "setUpViewModel")
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(ApiBuilder.apiInterface))
        ).get(MainViewModel::class.java)
    }

    override fun setFillData() {
        Log.d(TAG, "setFillData")
        if (mainViewModel != null) {
            mainViewModel!!.getUsers().observe(this, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { users ->
                                Log.d(TAG, "data: $users")
                            }
                        }
                        Status.ERROR -> {
                            Log.d(TAG, "Message: ${it.message}")
                        }
                        Status.LOADING -> {
                        }
                    }
                }
            })
        }
    }
}
