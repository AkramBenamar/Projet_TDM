package com.example

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tp3.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detailrdv.*


class detailrdvFragment : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm= ViewModelProvider(requireActivity()).get(RdvViewModel::class.java)
        textViewnomp.text=vm.nomp
        textViewprenompat.text=vm.prenomp
        textViewdaterdv3.text=vm.daterdv
        textViewheurd3.text=vm.heurdrdv
        textViewheurf3.text=vm.heurfrdv

        textViewnommed3.text=vm.nom
        textViewprenommed3.text=vm.prenom
        textViewspecrd3.text=vm.specialite
        //*********************QR****************

        val content = "Patient: "+vm.nomp+"--"+vm.prenomp+" a rendez vous le "+vm.daterdv+" a "+vm.heurdrdv+" chez Dr "+vm.nom+" "+vm.prenom

        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }
        imageViewQr.setImageBitmap(bitmap)
//*******************ENDQR******************

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailrdv, container, false)
    }


}