package com.example.gmailapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emailList: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_mail, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.avatar.text = email.sender.first().toString()
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.snippet.text = email.snippet
        holder.timestamp.text = email.timestamp
    }

    override fun getItemCount(): Int = emailList.size

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: TextView = itemView.findViewById(R.id.avatar)
        val sender: TextView = itemView.findViewById(R.id.sender)
        val subject: TextView = itemView.findViewById(R.id.subject)
        val snippet: TextView = itemView.findViewById(R.id.snippet)
        val timestamp: TextView = itemView.findViewById(R.id.timestamp)
    }
}