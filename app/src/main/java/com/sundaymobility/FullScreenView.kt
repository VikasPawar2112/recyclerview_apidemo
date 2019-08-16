package com.sundaymobility

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sundaymobility.network.responsepojo.UserData
import kotlinx.android.synthetic.main.activity_fullscreen_view.*

class FullScreenView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_view)
        val bundle = intent.extras
        if (bundle != null) {
            val userDataBean = bundle.getParcelable<UserData>("userData")
            println("${userDataBean?.login}")
            Glide.with(this).load(userDataBean?.avatarUrl)
                .apply(RequestOptions().centerCrop())
                .into(fullScreenView)
        } else {
            Toast.makeText(this, R.string.some_went_wrong, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}