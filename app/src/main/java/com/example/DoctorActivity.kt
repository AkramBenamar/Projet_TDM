package com.example

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp3.R
import com.google.zxing.Result
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_doctor.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
class DoctorActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)
        Dexter.withActivity(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object :PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                zxscan.setResultHandler(this@DoctorActivity)
                    zxscan.startCamera()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    Toast.makeText(this@DoctorActivity, "Vous Devez accepter la permission", Toast.LENGTH_SHORT).show()
                }


            }).check()

        retour.setOnClickListener {
            val intent =Intent(this,dochomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun handleResult(rawResult: Result?) {
        txt_result.text=rawResult!!.text
    }
}