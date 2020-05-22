package com.kotlin.kotlinprojectdemo.ui.fragment

import android.util.Log

import com.kotlin.kotlinprojectdemo.R
import com.kotlin.kotlinprojectdemo.ui.base.BaseFragment


class AccountFragmen : BaseFragment() {
    private val TAG: String = "AccountFragmen"

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragmen()
    }

    override fun getRootLayoutId(): Int {
        Log.d(TAG, "setupUI")
        return R.layout.fragment_account
    }

    override fun setUpViewModel() {
    }

//    override fun getViewModel(): Class<ViewModel> {
//        return ViewModel::class.java
//    }

    override fun setFillData() {
        Log.d(TAG, "setFillData")
    }

}
