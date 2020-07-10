package kupluk.smk.coding.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_add_news.*
import kupluk.smk.coding.R
import kupluk.smk.coding.data.News

class AddNewsActivity : AppCompatActivity() {
    companion object {
        const val PICK_IMAGE = 1
    }

    private var mImageUri: Uri? = null
    private lateinit var mStorageRef: StorageReference
    private lateinit var mDatabaseRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads")
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads")
        btn_choose_file.setOnClickListener { openFileChooser() }
        btn_submit.setOnClickListener {
            uploadFile()
        }
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            mImageUri = data.data
            Glide.with(this).load(mImageUri).into(view_image)
        }
    }

    private fun getFileExtension(uri: Uri): String? {
        val cR = contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(cR.getType(uri))
    }

    private fun uploadFile() {
        if (mImageUri != null) {
            val fileReference = mStorageRef.child(System.currentTimeMillis().toString() + "." + getFileExtension(mImageUri!!))
            val uploadTask = mStorageRef.putFile(mImageUri!!)
                uploadTask.continueWithTask{
                    if (!it.isSuccessful) {
                        Log.d("upload", "gagal")
                    }
                    mStorageRef.downloadUrl
                }.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.d("urldownload", it.result.toString())
                        val upload = News(edt_news_title.text.toString(), edt_news_description.text.toString(), it.result.toString())
                        val uploadID = mDatabaseRef.push().key
                        mDatabaseRef.child(uploadID.toString()).setValue(upload)
                    }
                }

        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show()
        }
    }
}


//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.storage.FirebaseStorage
//import com.google.firebase.storage.StorageReference
//import kotlinx.android.synthetic.main.activity_add_news.*
//import kupluk.smk.coding.R
//
//class AddNewsActivity : AppCompatActivity() {
//
//    companion object {
//        const val PICK_IMAGE = 1
//    }
//
//    private lateinit var mStorageRef: StorageReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_news)
//
//        mStorageRef = FirebaseStorage.getInstance().getReference("uploads")
//
//        btn_choose_file.setOnClickListener {
//            chooseFile()
//        }
//
//        btn_submit.setOnClickListener {
//
//        }
//    }
//
//    private fun chooseFile() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(intent, PICK_IMAGE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        val uploadTask = mStorageRef.putFile(data!!.data!!)
//        uploadTask.continueWithTask{
//            if (!it.isSuccessful) {
//                Log.d("upload", "gagal")
//            }
//            mStorageRef.downloadUrl
//        }.addOnCompleteListener {
//            if (it.isSuccessful) {
//                Log.d("urldownload", it.result.toString())
//            }
//        }
//    }
//}