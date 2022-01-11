package com.example.recyclerviewmultiadapter.moduls

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmultiadapter.R

class Adapter(val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES =1
    private val TYPE_AVAILABLE_NOT =0

    override fun getItemViewType(position: Int): Int {
        return if(members[position].isAvailable){
            TYPE_AVAILABLE_YES
        }else TYPE_AVAILABLE_NOT
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_yes,parent,false)
           return CustomViewYesHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layoutnot,parent,false)
        return CustomViewNotHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)
        if(holder is CustomViewYesHolder){
            holder.first_name.text = member.name
            holder.last_name.text = member.surname
        }
        if (holder is CustomViewNotHolder){
            holder.first_namet.text = "This name is not available"
            holder.last_namet.text = "This surname is not available"
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewYesHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val first_name: TextView = itemView.findViewById<TextView>(R.id.first_name)
        val last_name: TextView = itemView.findViewById<TextView>(R.id.last_name)
    }
    class CustomViewNotHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        val first_namet: TextView = itemView.findViewById<TextView>(R.id.first_namet)
        val last_namet: TextView = itemView.findViewById<TextView>(R.id.last_namet)
    }


}