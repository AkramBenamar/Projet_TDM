package com.example

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entity.infordv
import com.example.entity.patmed
import com.example.entity.traitementsinfo
import com.example.retrofit.RetrofitService
import com.example.tp3.R
import kotlinx.android.synthetic.main.fragment_listrdv.*
import kotlinx.android.synthetic.main.fragment_listtraitements.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listtraitementsFragment : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listtraitements.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        gettraitements()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listtraitements, container, false)
    }

    fun gettraitements(){
        val pref=this.requireActivity().getSharedPreferences("db", Context.MODE_PRIVATE)


        val idpat=pref.getInt("iduser",0)

        val patmed= patmed(0,idpat,"")
        val call= RetrofitService.endpoint.getmytraitements(patmed)

        call.enqueue(object: Callback<List<traitementsinfo>> {

            override fun onResponse(call: Call<List<traitementsinfo>>, response: Response<List<traitementsinfo>>) {

                if (response.code()==200){

                    val data=response.body()
                    if(data!=null){


                       // val vm = ViewModelProvider(requireActivity()).get(RdvViewModel::class.java)
                        listtraitements.adapter = TraitementsAdapter(requireActivity(),data)


                    }
                }
                else{

                }
            }
            override fun onFailure(call: Call<List<traitementsinfo>>, t: Throwable) {
                Toast.makeText(context , "UNE ERREUR S'EST PRODUITE POUR LES MEDCINS", Toast.LENGTH_SHORT).show()
            }


        });


    }
}