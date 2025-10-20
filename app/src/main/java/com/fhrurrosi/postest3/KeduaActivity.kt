package com.fhrurrosi.postest3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fhrurrosi.postest3.databinding.ActivityKeduaBinding
import com.fhrurrosi.postest3.databinding.ActivityMainBinding

class KeduaActivity : AppCompatActivity() {
    lateinit var binding: ActivityKeduaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityKeduaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val fullname = intent.getStringExtra("EXTRA_FULLNAME")
        val username = intent.getStringExtra("EXTRA_USERNAME")
        val age = intent.getStringExtra("EXTRA_AGE")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        binding.apply{
            hasilfullname.text = fullname
            hasilusername.text = username
            hasilumur.text = age
            hasilemail.text = email
            hasilgender.text = gender
        }

        binding.btnkembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}