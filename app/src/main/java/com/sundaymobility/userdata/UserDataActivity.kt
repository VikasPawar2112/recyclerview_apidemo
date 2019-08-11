package com.sundaymobility.userdata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.sundaymobility.R

import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        setSupportActionBar(toolbar)
    }

}
