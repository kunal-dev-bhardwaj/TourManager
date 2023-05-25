package com.inmortal.tourmanager.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.inmortal.tourmanager.CustomProgressDialog

import com.inmortal.tourmanager.databinding.ActivityLoginBinding
import com.inmortal.tourmanager.model.LogInModel
import com.inmortal.tourmanager.model.OtpModel
import com.inmortal.tourmanager.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var name: String
    lateinit var number: String
    lateinit var email: String
    var progress=CustomProgressDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            name = binding.etName.text.toString()
            number = binding.etMobile.text.toString()
            email = binding.etEmail.text.toString()

            progress.showProgressBar()
            loginApi(name, number, email)

        }
    }

    private fun loginApi(name: String, mobile: String, email: String) {
        ApiClient.getRetrofitService(this).logIn(
            name, mobile, email
        ).enqueue(object : Callback<LogInModel> {
            override fun onResponse(call: Call<LogInModel>, response: Response<LogInModel>) {
                progress.hideProgressBar()
                var logInModel: LogInModel? = response.body()
                var success = logInModel?.success
                var otp = logInModel?.otp
                if (success == true) {
                    Toast.makeText(this@LoginActivity, "" + otp, Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@LoginActivity, OtpActivity::class.java))
                } else {
                    Toast.makeText(this@LoginActivity, "something went wrong", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<LogInModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "" + t.message, Toast.LENGTH_SHORT).show()
            }

        })


    }


}