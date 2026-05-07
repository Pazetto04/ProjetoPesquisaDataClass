package com.example.projetobottomnav


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter (private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<DataAdapter.ViewHolderClass>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvUsername.text = currentItem.dataTitle
        holder.rvDesc.text = currentItem.dataId
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
            val rvImage: ImageView = itemView.findViewById(R.id.user_img)
            val rvUsername: TextView = itemView.findViewById(R.id.channel_name)
            val rvDesc: TextView = itemView.findViewById(R.id.channel_desc)
    }
}