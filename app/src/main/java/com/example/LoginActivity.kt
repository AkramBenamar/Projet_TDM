package com.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.work.ListenableWorker

import com.example.entity.login
import com.example.entity.users
import com.example.retrofit.RetrofitService
import com.example.MainActivity
import com.example.tp3.R

import kotlinx.android.synthetic.main.activity_login2.*
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
        val connected =pref.getBoolean("connected",false)
        val tp =pref.getString("type","")
        if(connected==true){
            if(tp.equals("pat")){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, dochomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        login.setOnClickListener {
            val mail=username.text.toString()

            val pw=password.text.toString()

            val l= login(mail,pw)
            Toast.makeText(this@LoginActivity, l.numtu+" "+l.pwd, Toast.LENGTH_SHORT).show()

            //val call= RetrofitService.endpoint.login(l)


            val result = RetrofitService.endpoint.login(l)
            result.enqueue(object: Callback<List<users>> {

                override fun onFailure(call: Call<List<users>>?, t: Throwable?) {

                    Toast.makeText(this@LoginActivity , "UNE ERREUR S'EST PRODUITE", Toast.LENGTH_SHORT).show()



                }

                override fun onResponse(call: Call<List<users>>?, response: Response<List<users>>?) {

                    if(response?.isSuccessful!!) {

                        val data=response.body()

                        if(data!=null){
                            Toast.makeText(this@LoginActivity, "LOGGED", Toast.LENGTH_SHORT).show()

                                val n=data.size
                                                    if(n!=0){
                                                        val mailatt=data[0].numtu
                                                        //val mailatt=""
                                                        val pwatt=data[0].pwd
                                                        val type=data[0].type
                                                        val nomu=data[0].nomu
                                                        val prenomu=data[0].prenomu
                                                        val iduser=data[0].iduser
                                                        //val pwatt=""
                                                        if(mail.equals(mailatt) && pw.equals(pwatt)){
                                                            val pref = getSharedPreferences("db", Context.MODE_PRIVATE)
                                                            pref.edit {
                                                                putBoolean("connected",true)
                                                                // putBoolean("patient",true)
                                                                 putString("type",type)
                                                                putString("nomu",nomu)
                                                                putString("prenomu",prenomu)
                                                                putInt("iduser",iduser)
                                                            }
                                                            Toast.makeText(this@LoginActivity, "LOGGED", Toast.LENGTH_SHORT).show()
                                                            if(type.equals("pat")){
                                                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                                                startActivity(intent)
                                                                finish()

                                                            }
                                                            else{
                                                                //lancer l activity du medcin
                                                                val intent = Intent(this@LoginActivity, dochomeActivity::class.java)
                                                                startActivity(intent)
                                                                finish()

                                                            }


                                                        }
                                                        else{
                                                            Toast.makeText(this@LoginActivity, "INTRODUISEZ LE BON LOGIN", Toast.LENGTH_SHORT).show()

                                                        }

                                                    }
                                                 else{
                                                        Toast.makeText(this@LoginActivity, "INTRODUISEZ LE BON LOGIN", Toast.LENGTH_SHORT).show()

                                                    }




                        }

                    }
                    else
                    {
                        Toast.makeText(this@LoginActivity, "Erreur Réseau", Toast.LENGTH_SHORT).show()


                    }
                }

            })


        }
    }


}