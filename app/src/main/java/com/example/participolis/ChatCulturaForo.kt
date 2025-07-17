package com.example.participolis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.SharedPreferences
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class ChatCulturaForo : AppCompatActivity() {
    private lateinit var chatListView: ListView
    private lateinit var chatEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var adapter: ArrayAdapter<String>
    private val messages = mutableListOf<String>()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var chatKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_cultura_foro)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar3)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        chatKey = intent.getStringExtra("chatKey") ?: return

        chatListView = findViewById(R.id.chatListView)
        chatEditText = findViewById(R.id.chatEditText)
        sendButton = findViewById(R.id.sendButton)
        sharedPreferences = getSharedPreferences("ChatPrefs", Context.MODE_PRIVATE)

        loadSavedMessages()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        chatListView.adapter = adapter

        sendButton.setOnClickListener {
            val message = chatEditText.text.toString()
            if (message.isNotEmpty()) {
                messages.add(message)
                saveMessage(message)
                adapter.notifyDataSetChanged()
                chatEditText.text.clear()
                chatListView.smoothScrollToPosition(messages.size - 1)
            }
        }
    }

    private fun saveMessage(message: String) {
        val editor = sharedPreferences.edit()
        val currentMessages = sharedPreferences.getStringSet(chatKey, mutableSetOf())
        currentMessages?.add(message)
        editor.putStringSet(chatKey, currentMessages)
        editor.apply()
    }

    private fun loadSavedMessages() {
        val savedMessages = sharedPreferences.getStringSet(chatKey, mutableSetOf())
        if (!savedMessages.isNullOrEmpty()) {
            messages.addAll(savedMessages)
        }
    }
}