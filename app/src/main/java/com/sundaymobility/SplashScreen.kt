package com.sundaymobility

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.sundaymobility.userdata.UserDataActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            val intent = Intent(this, UserDataActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}