package com.inmortal.tourmanager

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import java.util.*


class CustomProgressDialog(mContext: Context) {
    private var dialog: Dialog? = null
    private val mContext: Context

    init {
        this.mContext = mContext
    }

    fun showProgressBar() {
        dialog = Dialog(mContext)
        dialog?.setCancelable(false)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.loader_layout)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(Objects.requireNonNull(dialog?.getWindow())?.getAttributes())
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog?.getWindow()?.setAttributes(lp)
        dialog?.getWindow()?.setBackgroundDrawableResource(R.color.transparent)
        dialog?.show()
    }



    fun hideProgressBar() {
        dialog?.dismiss()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private val `object`: CustomProgressDialog? = null
        fun getInstance(mContext: Context): CustomProgressDialog? {
            return `object` ?: CustomProgressDialog(mContext)
        }
    }
}