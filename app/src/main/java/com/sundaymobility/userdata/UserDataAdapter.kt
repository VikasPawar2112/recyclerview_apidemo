package com.sundaymobility.userdata

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sundaymobility.R
import com.sundaymobility.network.responsepojo.UserData

class UserDataAdapter(val context: Context, private var userDataList: MutableList<UserData>, var onClickImage: IUserDataAdapter) :
    RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_user_data, parent, false)
        return UserDataViewHolder(view)
    }

    override fun getItemCount() = userDataList.size

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val userDataBean = userDataList[position]
        Glide.with(context).load(userDataList.get(position).avatarUrl)
            .apply(RequestOptions().centerCrop())
            .into(holder.imgUserImage)
        holder.tvUserName.text = userDataBean.login
        holder.tvUserType.text = userDataBean.type

        holder.imgUserImage.setOnClickListener {
            onClickImage.onImageClickListener(userDataBean)
        }
    }

    class UserDataViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val imgUserImage: ImageView = itemView!!.findViewById(R.id.idUserImage)
        val tvUserName: TextView = itemView!!.findViewById(R.id.idUserName)
        val tvUserType: TextView = itemView!!.findViewById(R.id.idUserType)
    }

    fun addAll(_userDataList: MutableList<UserData>) {
        userDataList.addAll(_userDataList)
        notifyDataSetChanged()
    }

    fun clear() {
        userDataList.clear()
        notifyDataSetChanged()
    }

    interface IUserDataAdapter {
        fun onImageClickListener(userDataBean: UserData)
    }
}

