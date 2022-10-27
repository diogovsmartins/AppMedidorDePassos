package com.example.appmedidordepassos

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

private const val REQUEST_CODE=12
class CameraActivity : AppCompatActivity() {
    //request code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        var btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val takePictureIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(takePictureIntent.resolveActivity(this.packageManager)!=null){
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            }else {
                Toast.makeText(this,"unable to open camera", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode== REQUEST_CODE && resultCode== Activity.RESULT_OK) {
          val takenImage=  data?.extras?.get("data") as Bitmap
            val imageView=findViewById<ImageView>(R.id.photo_view)
            imageView.setImageBitmap(takenImage)
        }else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}