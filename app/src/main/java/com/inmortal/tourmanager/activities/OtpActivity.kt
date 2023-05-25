package com.inmortal.tourmanager.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.inmortal.tourmanager.CustomProgressDialog
import com.inmortal.tourmanager.R
import com.inmortal.tourmanager.databinding.ActivityOtpBinding
import com.inmortal.tourmanager.model.Data
import com.inmortal.tourmanager.model.OtpModel
import com.inmortal.tourmanager.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OtpActivity : AppCompatActivity() {
    lateinit var binding: ActivityOtpBinding
    lateinit var pinview: EditText
    private var progress = CustomProgressDialog(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnVerify.setOnClickListener {
            progress.showProgressBar()
            otpApi()
        }

    }


    private fun otpApi() {
        pinview = findViewById(R.id.pinview)
        val otp = pinview.text.toString()
        Log.d("edfg", otp)
        ApiClient.getRetrofitService(this).otp(otp)
            .enqueue(object : Callback<OtpModel> {
                override fun onResponse(call: Call<OtpModel>, response: Response<OtpModel>) {
                    progress.hideProgressBar()
                    Log.d("edfg", response.body().toString())
                    var otpModel: OtpModel? = response.body()
                    var success=otpModel?.success
                    if (success==true){
                        val data: ArrayList<Data>? = response.body()?.data
                        for (data in data!!) {
                            var otp2 = data.otp

                            Log.d("list", otp2.toString())
                        }
                        var message = otpModel?.message
                        Toast.makeText(this@OtpActivity, "" + message, Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@OtpActivity,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this@OtpActivity, "something went wrong", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<OtpModel>, t: Throwable) {
                    Toast.makeText(this@OtpActivity, ""+t.message, Toast.LENGTH_SHORT).show()
                }


            })


    }
}