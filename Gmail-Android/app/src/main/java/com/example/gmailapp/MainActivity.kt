package com.example.gmailapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val emailList = listOf(
            Email("Alice", "Meeting Reminder", "Don't forget the meeting at 10:00 AM", "9:15 AM"),
            Email("Bob", "New Project Update", "Here is the update on our new project...", "Yesterday"),
            Email("Alice", "Meeting Reminder", "Don't forget the meeting tomorrow...", "8:30 AM"),
            Email("Bob", "Special Offer", "Get 50% off on your next purchase...", "9:15 AM"),
            Email("Carol", "Lunch Plan", "Shall we have lunch at the new cafe?", "10:45 AM"),
            Email("Dave", "Project Update", "The project is on track and will be...", "11:20 AM"),
            Email("Eve", "Discount Code Inside", "Exclusive discount code just for you...", "1:00 PM")
        )

        val adapter = EmailAdapter(emailList)
        recyclerView.adapter = adapter
    }
}