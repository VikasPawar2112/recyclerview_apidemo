package com.sundaymobility.userdata

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sundaymobility.R
import com.sundaymobility.network.responsepojo.UserData
import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity(), UserDataView {

    private var userdataAdapter: UserDataAdapter? = null
    var presenters: UserDataPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        presenters = UserDataPresenterImpl(this)
        setSupportActionBar(toolbar)
        recyclerview.layoutManager = LinearLayoutManager(this)
        userdataAdapter = UserDataAdapter(this, mutableListOf())
        recyclerview.adapter = userdataAdapter
        presenters?.getUserData()
    }

    override fun onDestroy() {
        presenters?.onDestroyClass()
        super.onDestroy()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun success(message: String) {
    }

    override fun fail(message: String) {
    }

    override fun noInternet() {
    }

    override fun loadUserData(userDataList: MutableList<UserData>) {
        userdataAdapter?.clear()
        userdataAdapter?.addAll(userDataList)
    }

}
