package com.catalyst.chatme

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class UserAdapter(
    val context:Context,
    val userList: ArrayList<User>
): RecyclerView.Adapter <UserAdapter.UserViewHolder> (){

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //note that findview by id will not work well since i am not in an activity unless i use the itemview parameter
        val textName = itemView.findViewById<TextView>(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        //using holder here to inflate the view and i am trying to bind the users to the textview that has been created
        holder.textName.text =currentUser.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            context.startActivity(intent)

            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", FirebaseAuth.getInstance().currentUser?.uid)
        }

    }

}
