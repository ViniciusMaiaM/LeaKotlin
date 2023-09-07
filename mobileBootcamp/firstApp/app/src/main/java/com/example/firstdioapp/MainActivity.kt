package com.example.firstdioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // O desafío sera criar uma string no string.xml
        // E trocar o texto do xml e tornar internacional (USA, Espanhol ...)
    }
}