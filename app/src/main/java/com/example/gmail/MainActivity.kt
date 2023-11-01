package com.example.gmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = listOf(
            "Alice Johnson", "Bob Smith", "Charlie Brown", "David Lee", "Eve Anderson",
            "Frank Miller", "Grace Davis", "Henry Wilson", "Ivy Thomas", "Jack White",
            "Katherine Hall", "Liam Clark", "Mia Allen", "Noah Davis", "Olivia Scott",
            "Patrick Lee", "Quinn Green", "Rebecca Hill", "Samuel Young", "Taylor Adams",
            "Uma Wilson", "Victor Moore", "Willow Turner", "Xander Martinez", "Yara Walker",
            "Zane Harris", "Ava Lewis", "Brooklyn Taylor"
        )

// Danh sách nội dung email
        val emailContents = listOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.",
            "Duis aute irure dolor in reprehenderit in voluptate velit esse.",
            "Cillum dolore eu fugiat nulla pariatur, excepteur sint occaecat cupidatat.",
            "Non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        )

        val times = listOf("7:30 AM", "8:45 AM", "10:15 AM", "1:00 PM", "3:30 PM")

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val index = it + 1;
            val name = names[it % names.size]
            val content = emailContents[it % emailContents.size]
            val time = times[it % times.size]
            items.add(ItemModel(name, content, time))
        }

        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }
}