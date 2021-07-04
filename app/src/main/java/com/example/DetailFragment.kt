package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.work.*
import com.bumptech.glide.Glide
import com.example.entity.mmg
import com.example.roomDao.RoomService
import com.example.service.SyncService
import com.example.tp3.R
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        nomV.text=vm.nom
        prenomV.text=vm.prenom
        numV.text=vm.num_tel
        specialiteV.text=vm.specialite
        //fb.text=vm.fb
        anneV.text=vm.annee.toString()
        //pict.setImageResource(vm.photo )
        Glide.with(requireActivity()).load(url+vm.photo).into(pict)
        val pref=this.requireActivity().getSharedPreferences("db", Context.MODE_PRIVATE)

        pref.edit{
            putInt("iddoc",vm.idmed)
        }
        val iduser=pref.getInt("iduser",1)

        numV.setOnClickListener { view ->
            val numero = Uri.parse("tel:$numV")
            val intent = Intent(Intent.ACTION_DIAL, numero)
            startActivity(intent)
        }
        buttonmsg.setOnClickListener {
            val message=editTextTextmsg.text.toString()
            //SharedPreferences preferences = .getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
            //val prefs = PreferenceManager.getDefaultSharedPreferences(activity)

            // iciiiii   val msg=Message(1,2,message,2)
val msg= mmg(iduser, message, vm.idmed)
            RoomService.appDataBase.getMsgDao().addMessage(msg)
            Toast.makeText(requireActivity(), "MSG ADDED ON LOCAL", Toast.LENGTH_SHORT).show()

            scheduleSycn()
           /* val call= RetrofitService.endpoint.addMessage(msg)

            call.enqueue(object: Callback<String> {

                override fun onResponse(call: Call<String>, response: Response<String>) {

                    if (response.code()==200){

                        val data=response.body()
                        if(data!=null){
                            Toast.makeText(context , "message envoyé", Toast.LENGTH_SHORT).show()

                            //val vm = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                            //listMedecins.adapter = MyAdapter(requireActivity(),data,vm)


                        }
                    }
                    else{

                    }
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(context , "UNE ERREUR S'EST PRODUITE", Toast.LENGTH_SHORT).show()
                }


            });*/

        }


        rdv.setOnClickListener {
            rdv.findNavController().navigate(R.id.action_detailFragment_to_rdvFragment)

        }
    }


    private fun scheduleSycn() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.UNMETERED).
            //    setRequiresBatteryNotLow(true).
        build()
        val req= OneTimeWorkRequest.Builder (SyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = WorkManager.getInstance(requireActivity())
        workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)

    }
}