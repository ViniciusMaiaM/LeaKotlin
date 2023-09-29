package com.example.eletriccarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Late init variable
    lateinit var price : EditText
    lateinit var traveledKm : EditText
    lateinit var btnCalculate : Button
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setUpListerners()
    }

    fun setupView() {
        // Everything that is connect to the screen is called on R (Resource)
        // The type is referring to the screen component that are being called
        price = findViewById(R.id.et_price_kwh)
        btnCalculate = findViewById(R.id.btn_calculate)
        traveledKm = findViewById(R.id.et_km_traveled)
    }

    fun setUpListerners() {
        btnCalculate.setOnClickListener{
            calculate()
        }
    }

    fun calculate() {
        val price = price.text.toString().toFloat()
        val km = traveledKm.text.toString().toFloat()

        val resultValue = price / km
        result.text = resultValue.toString()
    }
}