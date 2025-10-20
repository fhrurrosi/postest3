package com.fhrurrosi.postest3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fhrurrosi.postest3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            btn.setOnClickListener{
                val inputFullname = fullname.text.toString()
                val inputUsername = username.text.toString()
                val inputAge = age.text.toString()
                val inputEmail = email.text.toString()
                var gender = ""
                if (btn1.isChecked){
                     gender = "Laki-Laki"
                }else if(btn2.isChecked){
                     gender = "Perempuan"
                }
                val intent = Intent(this@MainActivity, KeduaActivity::class.java)
                    .putExtra("EXTRA_FULLNAME", inputFullname)
                    .putExtra("EXTRA_USERNAME", inputUsername)
                    .putExtra("EXTRA_AGE", inputAge)
                    .putExtra("EXTRA_EMAIL", inputEmail)
                    .putExtra("EXTRA_GENDER", gender)
                startActivity(intent)


            }
        }

    }
}