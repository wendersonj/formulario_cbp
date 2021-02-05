package com.service.cbp

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class TerceiraEtapa : Fragment() {

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
        //private const val CAMERA_REQUEST_CODE = 2
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // TODO mudar o find by ID para binding
        val view = inflater.inflate(R.layout.fragment_terceira_etapa, container, false)

        val btnCamera = view.findViewById<Button>(R.id.terceiraEtapa_btnCamera)
        btnCamera.setOnClickListener {

            takePicture()
        }

        val btnVoltar = view.findViewById<Button>(R.id.terceiraEtapa_botaoVoltar)
        btnVoltar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_terceiraEtapa_to_segundaEtapa)
        }

        //TODO navegar ate a proxima etapa
        val btnContinuar = view.findViewById<Button>(R.id.terceiraEtapa_botaoContinuar)
        btnContinuar.setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_terceiraEtapa_to_quartaEtapa)
        }
        return view
    }

    private fun takePicture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(context!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            val imageView = view!!.findViewById<ImageView>(R.id.terceiraEtapa_imageView)
            imageView.setImageBitmap(imageBitmap)
        }
    }

    /*
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }
            else{
                Toast.makeText(context!!, "Ops. Nao ha permissao para usar a camera", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            val imageView = view!!.findViewById<ImageView>(R.id.terceiraEtapa_imageView)
            imageView.setImageBitmap(imageBitmap)
        }
    }
    */

}