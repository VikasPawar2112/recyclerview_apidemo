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

class UserDataAdapter(val context: Context, userDataList: MutableList<UserData>) :
    RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder>() {

    var userDataList: List<UserData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_user_data, parent, false)
        return UserDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        // return userDataList.size
        return 10
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {

        Glide.with(context).load(R.mipmap.ic_launcher/*userDataList.get(position).avatarUrl*/)
            .apply(RequestOptions().centerCrop())
            .into(holder.imgUserImage)
        holder.tvUserName.text = "Vikas"/*userDataList.get(position).login*/
        holder.tvUserType.text = "Pawar"/*userDataList.get(position).type*/
    }

    fun setuserDataListItems(userDataList: List<UserData>) {
        this.userDataList = userDataList;
        notifyDataSetChanged()
    }

    class UserDataViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val imgUserImage: ImageView = itemView!!.findViewById(R.id.idUserImage)
        val tvUserName: TextView = itemView!!.findViewById(R.id.idUserName)
        val tvUserType: TextView = itemView!!.findViewById(R.id.idUserType)
    }
}