package com.kotlin.kotlinprojectdemo.ui.base

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.kotlin.kotlinprojectdemo.R

abstract class BaseFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getRootLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setFillData()
    }

    abstract fun getRootLayoutId(): Int
    abstract fun setUpViewModel()
    abstract fun setFillData()

//    private lateinit var mProgressDialog: Dialog
//
//    fun showLoadingDialog() {
//        if (!isVisible) {
//            if (!this::mProgressDialog.isInitialized) {
//                mProgressDialog = Dialog(this!!.context!!)
//                mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//                mProgressDialog.setCancelable(false)
//                mProgressDialog.setContentView(R.layout.custom_progress_loading)
//                if (mProgressDialog.window != null && !requireActivity().isFinishing) {
//                    mProgressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        val lp = WindowManager.LayoutParams()
//                        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
//                        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
//                        lp.gravity = Gravity.CENTER
//                        mProgressDialog.window!!.attributes = lp
//                    } else {
//                        mProgressDialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
//                    }
//                    if (!mProgressDialog.isShowing) {
//                        mProgressDialog.show()
//                        Log.i("DoanPhu", "setProgress: success")
//                    }
//                }
//            }
//            activity?.let {
//                if (!requireActivity().isFinishing && this::mProgressDialog.isInitialized && !mProgressDialog.isShowing) {
//                    try {
//                        mProgressDialog.show()
//                        Log.i("DoanPhu", "setProgress: success")
//                    } catch (ex: Exception) {
//                        ex.printStackTrace()
//                    }
//                }
//            }
//        }
//    }
//
//    private fun hideLoadingDialog() {
//        if (this::mProgressDialog.isInitialized && mProgressDialog.isShowing) {
//            mProgressDialog.dismiss()
//        }
//    }
}