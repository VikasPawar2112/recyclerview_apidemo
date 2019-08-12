package com.sundaymobility.userdata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import com.sundaymobility.R
import com.sundaymobility.network.responsepojo.UserData

import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity() {

    private var userdataAdapter: UserDataAdapter? = null
    private var userDataList: MutableList<UserData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        setSupportActionBar(toolbar)
        recyclerview.layoutManager = LinearLayoutManager(this)
        userdataAdapter = UserDataAdapter(this, userDataList)
        recyclerview.adapter = userdataAdapter
    }
}
