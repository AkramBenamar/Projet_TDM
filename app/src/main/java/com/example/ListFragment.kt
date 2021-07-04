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
import com.example.retrofit.RetrofitService
import com.example.MainViewModel
import com.example.tp3.R
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


      //  fun loadData(): List<Medecin> {
         //   val data = mutableListOf<Medecin>()

        //    return data
       // }


        listMedecins.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        getdoctors()
    }
   fun getdoctors(){

      val call= RetrofitService.endpoint.getMedcins()

      call.enqueue(object:Callback<List<Medecin>>{

            override fun onResponse(call: Call<List<Medecin>>, response: Response<List<Medecin>>) {

                if (response.code()==200){

                    val data=response.body()
                    if(data!=null){


                        val vm = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                        listMedecins.adapter = MyAdapter(requireActivity(),data,vm)


                    }
                }
                else{

                }
            }
          override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
              Toast.makeText(context , "UNE ERREUR S'EST PRODUITE POUR LES MEDCINS", Toast.LENGTH_SHORT).show()
          }


        });


  }

}