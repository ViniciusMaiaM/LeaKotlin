package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Binding is the root of the aplication
        setContentView(binding.root)

        binding.buttonHello.setOnClickListener{/* Creates a event that is listening for
        the clicks on the button */
            val name : String = binding.editName.text.toString()
            binding.textView.text = "Hello " + name
        }
    }
}