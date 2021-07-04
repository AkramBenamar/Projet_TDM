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

import com.example.tp3.R
import com.example.url

//import com.example.url

class MyAdapter(val context: Context, var data: List<Medecin>, val vm: MainViewModel) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom = view.findViewById<TextView>(R.id.nom) as TextView
        val prenom = view.findViewById<TextView>(R.id.prenom) as TextView
        val num = view.findViewById<TextView>(R.id.num) as TextView
        val specialite = view.findViewById<TextView>(R.id.specialite) as TextView
        val photo = view.findViewById<ImageView>(R.id.photo) as ImageView
        val icon = view.findViewById<ImageView>(R.id.icon) as ImageView
        val medView = view.findViewById<ConstraintLayout>(R.id.medecin) as ConstraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(context).inflate(R.layout.medecin_layout, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.num.text = data[position].num_tel.toString()
        holder.specialite.text = data[position].specialite
        //holder.photo.setImageResource(data[position].photo)
        Glide.with(context).load(url  + data[position].photo).into(holder.photo)

        // Toast.makeText(context, url+data[position].photo, Toast.LENGTH_SHORT).show()

        holder.num.setOnClickListener { view ->
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
        }

        holder.medView.setOnClickListener {
            vm.nom = data[position].nom
            vm.prenom = data[position].prenom
            vm.num_tel = data[position].num_tel
            vm.specialite = data[position].specialite
            vm.fb = data[position].fb
            vm.annee = data[position].annee
            vm.photo = data[position].photo
            vm.idmed = data[position].iddoc

            holder.medView.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
    }
}



