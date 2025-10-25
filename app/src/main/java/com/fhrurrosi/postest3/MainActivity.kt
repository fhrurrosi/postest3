package com.fhrurrosi.postest3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.fhrurrosi.postest3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btn.setOnClickListener {
                val inputFullname = fullname.text.toString().trim()
                val inputUsername = username.text.toString().trim()
                val inputAge = age.text.toString().trim()
                val inputEmail = email.text.toString().trim()
                val inputPass = password.text.toString().trim()
                val reinputPass = repassword.text.toString().trim()
                var gender = ""
                if (btn1.isChecked) gender = "Laki-Laki"
                else if (btn2.isChecked) gender = "Perempuan"

                if (inputFullname.isEmpty() ||
                    inputUsername.isEmpty() ||
                    inputAge.isEmpty() ||
                    inputEmail.isEmpty() ||
                    gender.isEmpty() ||
                    inputPass.isEmpty() ||
                    reinputPass.isEmpty()
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "Semua field harus diisi!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Format email tidak valid!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                val intent = Intent(this@MainActivity, KeduaActivity::class.java)
                intent.putExtra("EXTRA_FULLNAME", inputFullname)
                intent.putExtra("EXTRA_USERNAME", inputUsername)
                intent.putExtra("EXTRA_AGE", inputAge)
                intent.putExtra("EXTRA_EMAIL", inputEmail)
                intent.putExtra("EXTRA_GENDER", gender)
                startActivity(intent)
            }
        }
    }
}
