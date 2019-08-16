package com.sundaymobility.userdata

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sundaymobility.R
import com.sundaymobility.network.responsepojo.UserData
import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity(), UserDataView {

    private var userdataAdapter: UserDataAdapter? = null
    var presenters: UserDataPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.toolbar_name_home)
        presenters = UserDataPresenterImpl(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        userdataAdapter = UserDataAdapter(this, mutableListOf())
        recyclerview.adapter = userdataAdapter
        presenters?.getUserData()
        addAction.setOnClickListener { view ->
            Snackbar.make(view, R.string.snackbar_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, null)
                .show()
        }
    }

    override fun onDestroy() {
        presenters?.onDestroyClass()
        super.onDestroy()
    }

    override fun showLoading() {
        progressbarShowLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressbarShowLoading.visibility = View.GONE
    }

    override fun fail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun noInternet() {
        Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show()
    }

    override fun loadUserData(userDataList: MutableList<UserData>) {
        userdataAdapter?.clear()
        userdataAdapter?.addAll(userDataList)
    }
}
