package com.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController


import kotlinx.android.synthetic.main.fragment_list.*
import com.example.tp3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
        val nomu = pref.getString("nomu", "")
        bjr2.text = "Bonjour " + nomu + "!"


        dec.setOnClickListener {
            // val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
            pref.edit {
                putBoolean("connected", false)

            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        gordvs.setOnClickListener {
            val intent = Intent(this@MainActivity, RdvActivity::class.java)
            startActivity(intent)
        }
        gotraitements.setOnClickListener {
            val intent = Intent(this@MainActivity, TraitementsActivity::class.java)
            startActivity(intent)
        }

        val nav = findNavController(R.id.nav_host)
        setupActionBarWithNavController(nav)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp()
    }


    /*private fun getdoctors(){
        val call= RetrofitService.endpoint.getMedcins()
        call.enqueue(object: Callback<List<Medecin>> {
            override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                if (response.code)
            }

            override fun onResponse(call: Call<List<Medecin>>, response: Response<List<Medecin>>) {
                Toast.makeText(this@MainActivity, "UNE ERREUR S'EST PRODUITE", Toast.LENGTH_SHORT).show()
            }

        })

    }*/
}



