package com.inmortal.tourmanager.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.inmortal.tourmanager.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_TIME = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed(

            {

//                if (user.isEmpty()) {
//                    val i = Intent(this@SplashActivity, TutorialActivity::class.java)
//                    startActivity(i)
//                    finish()
//                } else if (!user.isEmpty()) {
//                    val i = Intent(this@SplashActivity, MainActivity::class.java)
//                    startActivity(i)
//                    finish()
//                }
            startActivity(Intent(this,LoginActivity::class.java))

            }, SPLASH_DISPLAY_TIME.toLong())

    }
}