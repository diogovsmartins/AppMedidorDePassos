package com.example.appmedidordepassos

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView

class CameraActivity : AppCompatActivity() {
    //request code
     var requestCode : Int=123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        var btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            openCamera()
        }
    }

    fun openCamera  (){
        //start camera
        var intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager)!=null){
            startActivityForResult(intent,requestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==resultCode && resultCode== RESULT_OK){
            val imageView: ImageView =findViewById(R.id.photo_view)
            //START BITMAP
            val bitmap=data?.extras?.get("data") as Bitmap
            //set image bitmap
            imageView.setImageBitmap(bitmap)
        }
    }
}