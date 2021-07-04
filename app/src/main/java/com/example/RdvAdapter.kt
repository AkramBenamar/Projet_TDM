package com.example

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.infordv
import com.example.tp3.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.io.File
import java.io.FileOutputStream


//import com.example.url

class RdvAdapter(val context: Context, var data: List<infordv>, val vm: RdvViewModel) :
    RecyclerView.Adapter<RdvAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val daterdv = view.findViewById<TextView>(R.id.textViewdaterdv) as TextView
        val nom = view.findViewById<TextView>(R.id.textViewnommed) as TextView
        val prenom = view.findViewById<TextView>(R.id.textViewprenommed) as TextView

        val heurd = view.findViewById<TextView>(R.id.textViewheurd) as TextView
        val heurf = view.findViewById<TextView>(R.id.textViewheurf) as TextView


        val specialite = view.findViewById<TextView>(R.id.textViewspecrd) as TextView

        val rdvView = view.findViewById<ConstraintLayout>(R.id.rdvl) as ConstraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rdv_layout, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.daterdv.text = data[position].daterdv.toString()
        holder.heurd.text = data[position].heurdrdv
        holder.heurf.text = data[position].heurfrdv
        holder.specialite.text = data[position].specialite

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

        holder.rdvView.setOnClickListener{
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
        }
    }
}



