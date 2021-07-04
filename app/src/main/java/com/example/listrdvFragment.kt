package com.example

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entity.Medecin
import com.example.entity.infordv
import com.example.entity.patmed
import com.example.retrofit.RetrofitService
import com.example.tp3.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_listrdv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listrdvFragment : Fragment() {
   

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listrdvs.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        getrdvs()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listrdv, container, false)
    }
    fun getrdvs(){
        val pref=this.requireActivity().getSharedPreferences("db", Context.MODE_PRIVATE)


        val idpat=pref.getInt("iduser",0)

        val patmed= patmed(0,idpat,"")
        val call= RetrofitService.endpoint.getmyrdvs(patmed)

        call.enqueue(object: Callback<List<infordv>> {

            override fun onResponse(call: Call<List<infordv>>, response: Response<List<infordv>>) {

                if (response.code()==200){

                    val data=response.body()
                    if(data!=null){


                        val vm = ViewModelProvider(requireActivity()).get(RdvViewModel::class.java)
                        listrdvs.adapter = RdvAdapter(requireActivity(),data,vm)


                    }
                }
                else{

                }
            }
            override fun onFailure(call: Call<List<infordv>>, t: Throwable) {
                Toast.makeText(context , "UNE ERREUR S'EST PRODUITE POUR LES MEDCINS", Toast.LENGTH_SHORT).show()
            }


        });


    }

}