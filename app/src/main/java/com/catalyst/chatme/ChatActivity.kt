package com.catalyst.chatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {
    private lateinit var rvChat: RecyclerView
    private lateinit var etMessageBox: EditText
    private lateinit var sendButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        rvChat = findViewById(R.id.rvChat)
        etMessageBox = findViewById(R.id.etMessageBox)
        sendButton = findViewById(R.id.imgSendButton)


    }
}