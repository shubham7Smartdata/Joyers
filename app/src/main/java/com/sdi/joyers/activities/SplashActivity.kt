package com.sdi.joyers.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sdi.joyers.R
import com.sdi.joyers.utils.Constants

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }, Constants.SPLASH_TIME_OUT)
    }

}