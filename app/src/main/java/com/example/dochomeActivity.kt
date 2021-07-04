package com.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.tp3.R
import kotlinx.android.synthetic.main.activity_dochome.*
import kotlinx.android.synthetic.main.activity_main.*

class dochomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dochome)
        decdoc.setOnClickListener {
             val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
            pref.edit {
                putBoolean("connected",false)

            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        scan.setOnClickListener {
            val intent =Intent(this,DoctorActivity::class.java)
            startActivity(intent)

        }
    }
}