package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.entity.Medecin
import com.example.MainViewModel
import com.example.entity.infordv
import com.example.entity.traitementsinfo

import com.example.tp3.R
import com.example.url

//import com.example.url

class TraitementsAdapter(val context: Context, var data: List<traitementsinfo>) ://, val vm: RdvViewModel
    RecyclerView.Adapter<TraitementsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val specT = view.findViewById<TextView>(R.id.specT) as TextView
        val nomdocT = view.findViewById<TextView>(R.id.nomdocT) as TextView
        val prenomdocT = view.findViewById<TextView>(R.id.prenomdocT) as TextView

        val descT = view.findViewById<TextView>(R.id.descT) as TextView
        val datedT = view.findViewById<TextView>(R.id.datedT) as TextView
        val datefT = view.findViewById<TextView>(R.id.datefT) as TextView

        val traitementView = view.findViewById<ConstraintLayout>(R.id.traitementl) as ConstraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.traitement_layout, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nomdocT.text = data[position].nom
        holder.prenomdocT.text = data[position].prenom
        holder.datedT.text = data[position].datedtraitement.toString()
        holder.datefT.text = data[position].dateftraitement.toString().take(10)
        holder.specT.text = data[position].specialite
        holder.descT.text = data[position].desctraitement

        //holder.photo.setImageResource(data[position].photo)
        //Glide.with(context).load("https://c6a57e250331.ngrok.io/"+data[position].photo).into(holder.photo)

        // Toast.makeText(context, url+data[position].photo, Toast.LENGTH_SHORT).show()

        /*    holder.num.setOnClickListener { view ->
                val numTel = data[position].num_tel
                val numero = Uri.parse("tel:$numTel")
                val intent = Intent(Intent.ACTION_DIAL, numero)
                context.startActivity(intent)
            }
    //Ici mettre la fonction de l ittiniraire
            holder.icon.setOnClickListener { view ->
                val latitude = data[position].latitude
                val longitude = data[position].longitude
                val geoLocation = Uri.parse("geo:$latitude,$longitude")
                val intent = Intent(Intent.ACTION_VIEW, geoLocation)
                context.startActivity(intent)
            }*/

      /*  holder.rdvView.setOnClickListener{
            vm.nom= data[position].nom
            vm.prenom = data[position].prenom
            vm.daterdv = data[position].daterdv
            vm.specialite  = data[position].specialite
            vm.heurdrdv = data[position].heurdrdv
            vm.heurfrdv = data[position].heurfrdv
            vm.nomp=data[position].nomp
            vm.prenomp=data[position].prenomp
            vm.iddoc=data[position].iddoc
            vm.idpat=data[position].idpat
            vm.qrrdv=data[position].qrrdv


            holder.rdvView.findNavController().navigate(R.id.action_listrdvFragment_to_detailrdvFragment)
        }*/
    }
}



