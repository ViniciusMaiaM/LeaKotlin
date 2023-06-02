package com.example.eurodolarconversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eurodolarconversor.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            // Infered type
            val euros = binding.editEuro.text.toString().toDouble()
            //val dolars = String.format("%.2f", euros * 0.8)
            val dolars = (euros * 0.8 * 100).roundToInt().toDouble() / 100
            binding.textDolar.text = "Dolar: ${dolars} $"
        }
    }
}