package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Patterns
import android.widget.Toast
import com.example.loginpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val email = binding.emailField.text.toString()
            val password = binding.passwordField.text.toString()

            val emailError = validateEmail(email)
            val passwordError = validatePassword(password)

            if (emailError != null) {
                binding.emailField.error = emailError
            } else if (passwordError != null) {
                binding.passwordField.error = passwordError
            }
            else {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.forget.setOnClickListener{
            Toast.makeText(this, "Route to create a new password screen", Toast.LENGTH_SHORT).show()
        }
        binding.first.setOnClickListener{
            Toast.makeText(this, "Route to create a account screen", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateEmail(email: String): String? {
        return if (email.isEmpty()) {
            "Email Field cannot be empty"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            "Invalid email address"
        } else if (!isValidDomain(email.substringAfter("@"))) {
            "Invalid domain"
        } else {
            null
        }
    }

    private fun isValidDomain(domain: String): Boolean {
        return domain.endsWith("byteserido.com") || domain.endsWith("ufrn.edu.br")
    }

    private fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Password Field cannot be empty"
            password.length < 4 -> "Password must be at least 4 characters long"
            !password.matches(Regex(".*[a-z].*")) || !password.matches(Regex(".*[A-Z].*")) ->
                "Password must contain at least one uppercase and one lowercase letter"
            else -> null
        }
    }
}

